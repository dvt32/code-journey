/*

КУРСОВА РАБОТА 89

Да се разработят на програмен език C/C++ процедури за:

a)	Създаване на МНОГОМЕРЕН МАСИВ с елементи (с полета) от следния тип:
- реален

b)	Прехвърляне на информацията в ТЕКСТОВ ФАЙЛ

c)	Сортиране на текстовия файл

d)	Да се обработи сортирания текстов файл като за обработката се използва условие:
... да се отстранят всички елементи съдържащи  числа, чиято дробна част е по-голяма от 0.4

e)	Запазване на създадената в процедура c) структура като файл.

f)	Възстановяване на създадената в процедура e) структура от файл.

*/

#include "stdafx.h"
#include <time.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

#define NUMBER_OF_ROWS 2 // брой редове в масива
#define NUMBER_OF_COLS 3 // брой стълбове в масива
#define MAX_FLOAT_VALUE 5.0f // максимална стойност в масива от реални числа
#define FILE_PATH "D:\output.txt" // пътят към текстовия файл

float arr[NUMBER_OF_ROWS][NUMBER_OF_COLS];

// Функция, която пълни масива със случайни стойности
void fillArray() {
	for (int i = 0; i < NUMBER_OF_ROWS; ++i) {
		for (int j = 0; j < NUMBER_OF_COLS; ++j) {
			arr[i][j] = ( (float)rand() / (float)(RAND_MAX) ) * MAX_FLOAT_VALUE; // генерирай случайно реално число между 0.0 и MAX_FLOAT_VALUE включително
		}
	}
	printf("Array filled successfully!\n\n");
}

// Функция, която извежда стойностите в масива
void printArray() {
	printf("Contents of array: \n");
	for (int i = 0; i < NUMBER_OF_ROWS; ++i) {
		for (int j = 0; j < NUMBER_OF_COLS; ++j) {
			printf("%f ", arr[i][j]);
		}
		printf("\n");
	}
}

// Функция, която запазва стойностите от масива във файл
void saveArrayToFile() {
	FILE *f = fopen(FILE_PATH, "w"); // "w" - отвори файла в режим за записване на инфoрмация в него
	if (f == NULL) {
		printf("Error opening file!\n");
		return;
	}

	for (int i = 0; i < NUMBER_OF_ROWS; ++i) {
		for (int j = 0; j < NUMBER_OF_COLS; ++j) {
			fprintf(f, "%f ", arr[i][j]);
		}
		fprintf(f, "\n");
	}

	fclose(f);

	printf("File saved successfully!\n\n");
}

// Функция, която извежда съдържанието на файла
void printFile() {
	FILE *f = fopen(FILE_PATH, "r"); // "r" - отвори файла в режим за четене на информация от него
	if (f == NULL) {
		printf("Error opening file!\n");
		return;
	}

	char buffer[255];

	printf("Contents of file: \n");
	while( fgets(buffer, 255, f) ) {
		printf("%s", buffer);
	}

	fclose(f);
}

// Функция, която определя по какъв критерий се сортира масива от реални числа (в случая е във възходящ ред)
int compare (const void * a, const void * b) {
	if (*(const float*)a < *(const float*)b) {
		return -1;
	}
	return *(const float*)a > *(const float*)b;
}
// Функция, която сортира стойностите във файла (по ред) във възходящ ред
void sortFile() {
	FILE *f = fopen(FILE_PATH, "r"); // "r" - отвори файла в режим за четене
	if (f == NULL) {
		printf("Error opening file!\n");
		return;
	}

	// прочети стойностите от файла и ги запази във временен масив
	char buffer[255];
	float temp[NUMBER_OF_ROWS][NUMBER_OF_COLS];
	int i = 0, j = 0;
	while( fgets(buffer, 255, f) ) {
		char *number_on_line = strtok(buffer, " "); // прочети първото число на реда (разделител между числата е интервал)
		while (number_on_line != NULL) {
			if (strlen(number_on_line) == 1) { // пропусни знака за нов ред
				number_on_line = strtok(NULL, " ");
				continue;	
			}
			temp[i][j] = atof(number_on_line); // преобразувай числото във float
			number_on_line = strtok(NULL, " "); // прочети следващото число на реда
			
			j++;
		}
		i++;
		j = 0;
	}
	 
	// сортирай всеки ред от временния масив чрез вградената в stdlib.h функция qsort()
	for (int i = 0; i < NUMBER_OF_ROWS; ++i) {
		qsort(temp[i], sizeof(temp[i])/sizeof(temp[i][0]), sizeof(float), compare);
	}

	// обнови съдържанието на файла със сортираните стойности
	freopen(FILE_PATH, "w", f);
	for (int i = 0; i < NUMBER_OF_ROWS; ++i) {
		for (int j = 0; j < NUMBER_OF_COLS; ++j) {
			fprintf(f, "%f ", temp[i][j]);
		}
		fprintf(f, "\n");
	}

	printf("File sorted successfully!\n\n");

	fclose(f);
}

// функция, която пълни масива със стойностите от файла
void fillArrayFromFile() {
	FILE *f = fopen(FILE_PATH, "r"); // "r" - отвори файла в режим за четене
	if (f == NULL) {
		printf("Error opening file!\n");
		return;
	}

	// прочети стойностите от файла и ги запази в глобалния масив
	char buffer[255];
	int i = 0, j = 0;
	while( fgets(buffer, 255, f) ) {
		char *number_on_line = strtok(buffer, " "); // прочети първото число на реда (разделител между числата е интервал)
		while (number_on_line != NULL) {
			if (strlen(number_on_line) == 1) { // пропусни знака за нов ред
				number_on_line = strtok(NULL, " ");
				continue;	
			}
			arr[i][j] = atof(number_on_line); // преобразувай числото във float
			number_on_line = strtok(NULL, " "); // прочети следващото число на реда
			j++;
		}
		i++;
		j = 0;
	}

	printf("Array filled from file successfully!\n\n");

	fclose(f);
}

// Функция, която изтрива от файла числата, чиято дробна част е по-голяма от 0.4
void removeInvalidFileElements() {
	FILE *f = fopen(FILE_PATH, "r"); // "r" - отвори файла в режим за четене
	if (f == NULL) {
		printf("Error opening file!\n");
		return;
	}

	// прочети стойностите от файла и ги запази във временен масив
	char buffer[255];
	float temp[NUMBER_OF_ROWS][NUMBER_OF_COLS];
	int i = 0, j = 0;
	while( fgets(buffer, 255, f) ) {
		char *number_on_line = strtok(buffer, " "); // прочети първото число на реда (разделител между числата е интервал)
		while (number_on_line != NULL) {
			if (strlen(number_on_line) == 1) { // пропусни знака за нов ред
				number_on_line = strtok(NULL, " ");
				continue;	
			}
			temp[i][j] = atof(number_on_line); // преобразувай числото във float
			number_on_line = strtok(NULL, " "); // прочети следващото число на реда
			j++;
		}
		i++;
		j = 0;
	}
	 
	// обнови съдържанието на файла (не добавяй числата с дробна част по-голяма от 0.4)
	freopen(FILE_PATH, "w", f);
	for (int i = 0; i < NUMBER_OF_ROWS; ++i) {
		for (int j = 0; j < NUMBER_OF_COLS; ++j) {
			float fraction = temp[i][j] - (int) temp[i][j]; 
			if (fraction > 0.4) {
				continue;
			}
			fprintf(f, "%f ", temp[i][j]);
		}
		fprintf(f, "\n");
	}

	printf("Removed invalid elements (fractional part > 0.4) from file successfully!\n\n");

	fclose(f);
}

// Главна функция
int main()
{
	srand((unsigned int) time(NULL)); // извиква се само 1 път, за да може да се генерират случайни числа

	fillArray(); // напълни масива
	printArray(); // изведи стойностите му

	printf("\n---\n\n");

	saveArrayToFile(); // запази стойностите му във файл
	printFile(); // изведи съдържанието на файла

	printf("\n---\n\n");

	sortFile(); // сортирай стойностите във файла
	printFile(); // изведи новото съдържание на файла

	printf("\n---\n\n");

	fillArrayFromFile(); // напълни масива със стойностите от файла
	printArray(); // изведи новите стойностите на масива

	printf("\n---\n\n");

	removeInvalidFileElements(); // изтрий числата, чиято дробна част е по-голяма от 0.4
	printFile(); // изведи новото съдържание на файла

	printf("\n---\n\n");

	return 0;
}
