/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*

ЗАБЕЛЕЖКА: Намалих оценките до 5.

1. Да се състави програма, която със съхраняваните в масив данни за група студенти:
- име - низ до 25 знака;
- ЕГН - низ от 10 знака;
- оценки по 10 дисциплини – цели числа;
- курс - цяло число,

Извършва следните действия, избирани от меню:
- добавя към масива данни за пореден студент;
- извежда на екрана всички въведени данни;
- извежда данните на студентите мъже над 22 години от втори курс;
- създава масив с данните за студентките без слаби оценки;
- създава масив с имената, датата на раждане на студентите с успех над 4.50.

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <conio.h>
#include <stdlib.h>

class Student{
public:
	char name[26], EGN[11], gender[5], gender_number[2], dateofbirth[15];
	int ocenka[6], age, kurs;
	bool hasBadGrade;
	double uspeh;
	void cinStudentInfo();
	void coutStudentInfo();
	void findBirthday();
};

// Функция на Student за въвеждане на данните на студент
void Student::cinStudentInfo(){
	cout << "\n---\n";
	cin.ignore();
	cout << "Име на студент: "; cin.getline(name, 26);
	cout << "ЕГН: "; cin.getline(EGN, 11);
	cout << "Курс: "; cin >> kurs;
	for (int i = 0; i < 5; i++){
		cout << "- Оценка " << i << ": "; cin >> ocenka[i];
	} cout << "---\n";
}

// Функция на Student за извеждане на данните на студент
void Student::coutStudentInfo(){
	cout << "Име на студент: " << name << endl;
	cout << "ЕГН: " << EGN << endl;
	cout << "Курс: " << kurs << endl;
	cout << "Оценки: "; for (int i = 0; i < 5; i++){ cout << ocenka[i] << " "; };
	cout << endl;
}

// Функция за намиране пола на студентите
void findGender(Student Group[], int br){
	int gender_number;
	for (int i = 0; i < br; i++){
		strncpy_s(Group[i].gender_number, Group[i].EGN + 8, 1);
		gender_number = atoi(Group[i].gender_number);
		if (gender_number % 2 == 0) { strcpy_s(Group[i].gender, "мъж"); }
		else { strcpy_s(Group[i].gender, "жена"); };
	}
}

// Функция за намиране възрастта на студентите
void findAge(Student Group[], int br){
	int yearOfBirth[30], monthOfBirth[30];
	char yearOfBirth_s[3], monthOfBirth_s[3];
	for (int i = 0; i < br; i++){
		// Отделяне на годината на раждане
		strncpy_s(yearOfBirth_s, Group[i].EGN, 2);
		yearOfBirth[i] = atoi(yearOfBirth_s) + 1900;
		// Отделяне на месеца на раждане и корекция за родените след 1999 г.
		strncpy_s(monthOfBirth_s, Group[i].EGN + 2, 2);
		monthOfBirth[i] = atoi(monthOfBirth_s);
		if (monthOfBirth[i] > 12) { monthOfBirth[i] -= 40; yearOfBirth[i] += 100; }
		// Определяне на възрастта
		Group[i].age = 2015 - yearOfBirth[i];
	}
}

// Функция за проверяване дали студентите имат слаби оценки.
void findBadGrades(Student Group[], int br){
	for (int i = 0; i < br; i++){
		Group[i].hasBadGrade = 0;
		for (int j = 0; j < 5; j++){
			if (Group[i].ocenka[j] == 2) { Group[i].hasBadGrade = 1; break; }
		}
	}
}

// Функция за намиране датата на раждане на студентите
void findBirthday(Student Group[], Student Group3[], int br){
	int yearOfBirth[30], monthOfBirth[30], dayOfBirth[30];
	char yearOfBirth_s[6], monthOfBirth_s[4], dayOfBirth_s[3];
	for (int i = 0; i < br; i++){
		// Отделяне на годината на раждане
		strncpy_s(yearOfBirth_s, Group[i].EGN, 2);
		yearOfBirth[i] = atoi(yearOfBirth_s) + 1900;
		// Отделяне на месеца на раждане и корекция за родените след 1999 г.
		strncpy_s(monthOfBirth_s, Group[i].EGN + 2, 2);
		monthOfBirth[i] = atoi(monthOfBirth_s);
		if (monthOfBirth[i] > 12) { monthOfBirth[i] -= 40; yearOfBirth[i] += 100; }
		// Отделяне на деня на раждане
		strncpy_s(dayOfBirth_s, Group[i].EGN + 4, 2);
		dayOfBirth[i] = atoi(dayOfBirth_s);
		// Определяне на датата на раждане (ще изглежда така: ГГГГ.ММ.ДД)
		_itoa_s(yearOfBirth[i], yearOfBirth_s, 10);
		_itoa_s(monthOfBirth[i], monthOfBirth_s, 10);
		_itoa_s(dayOfBirth[i], dayOfBirth_s, 10);
		strcpy_s(Group3[i].dateofbirth, yearOfBirth_s);
		strcat_s(Group3[i].dateofbirth, ".");
		if (strlen(monthOfBirth_s) < 2) {
			strcat_s(Group3[i].dateofbirth, "0");
			strcat_s(Group3[i].dateofbirth, monthOfBirth_s);
		}
		else { strcat_s(Group3[i].dateofbirth, monthOfBirth_s); }
		strcat_s(Group3[i].dateofbirth, ".");
		if (strlen(dayOfBirth_s) < 2) {
			strcat_s(Group3[i].dateofbirth, "0");
			strcat_s(Group3[i].dateofbirth, dayOfBirth_s);
		}
		else { strcat_s(Group3[i].dateofbirth, dayOfBirth_s); }
	}
}

// Функция за изчисляване успеха на студентите
void findUspeh(Student Group[], Student Group3[], int br){
	int sum = 0; // сума на оценките за всеки студент;
	for (int i = 0; i < br; i++){
		for (int j = 0; j < 5; j++){
			sum += Group[i].ocenka[j];
		}
		Group3[i].uspeh = (double)sum / 5;
		sum = 0;
	}
}



void main(){
	system("chcp 1251");

	Student Group[30],
		Group2[30], // масив за опция 4 от менюто
		Group3[30]; // масив за опция 5 от менюто
	int menuCode,
		i, j,
		br = 0;		// брой студенти

	do
	{
		cout << endl << "МЕНЮ: " << endl;
		cout << " - [1]: Добави данни за студент" << endl;
		cout << " - [2]: Изведи данните за добавените студенти" << endl;
		cout << " - [3]: Изведи данните на студентите мъже над 22 години от втори курс" << endl;
		cout << " - [4]: Създай масив с данните за студентките без слаби оценки" << endl;
		cout << " - [5]: Създай масив с имената, датата на раждане на студентите с успех над 4.50" << endl;

		cout << endl << "Въведи номер на операция (0 за край): "; cin >> menuCode;

		switch (menuCode){
		case 0: break;
		case 1:
			Group[br++].cinStudentInfo(); break;
		case 2:
			cout << "\n---\n" << "Всички въведени данни: " << endl << endl;
			for (i = 0; i < br; i++) { Group[i].coutStudentInfo(); cout << "\n\n"; }
			cout << "---\n\n";
			break;
		case 3:
			findAge(Group, br);
			findGender(Group, br);
			cout << "\n---\n" << "Студенти мъже, над 22 годишни, 2 курс: " << endl << endl;
			 for (i = 0; i < br; i++)
			{
				if (Group[i].age > 22 && strcmp(Group[i].gender, "мъж") == 0 && Group[i].kurs == 2) 
				 { Group[i].coutStudentInfo(); cout << "\n\n"; }
			}
			cout << "---\n\n";
			break;
		case 4:
			findGender(Group, br); // намиране на пола
			findBadGrades(Group, br); // имат ли 2-ки?
			cout << "\n---\n" << "Студентки без 2-ки: " << endl << endl;
			for (i = 0, j = 0; i < br; ++i){
				if (Group[i].hasBadGrade == 0 && strcmp(Group[i].gender, "жена") == 0) {
					strcpy_s(Group2[j].name, Group[i].name);
					strcpy_s(Group2[j].EGN, Group[i].EGN);
					Group2[j].kurs = Group[i].kurs;
					for (int k = 0; k < 5; ++k){ Group2[j].ocenka[k] = Group[j].ocenka[k]; }
					Group2[j].coutStudentInfo();
					j++;
				}
			}
			cout << "\n---\n\n";
			break;
		case 5:
			findBirthday(Group, Group3, br);
			findUspeh(Group, Group3, br);
			cout << "\n---\n" << "Студенти с успех над 4.50: " << endl << endl;
			for (int i = 0; i < br; ++i){
				if (Group3[i].uspeh > 4.50)
				{
					strcpy_s(Group3[i].name, Group[i].name);
					cout << "Име на студент: " << Group3[i].name << endl;
					cout << "Дата на раждане: " << Group3[i].dateofbirth << endl;
					cout << "Успех: " << Group3[i].uspeh << endl << endl;
				}
			}
			cout << "\n---\n\n";
			break;
		default: cout << "Невалиден номер на операция." << endl;
		}
	}

	while (menuCode != 0);


}

