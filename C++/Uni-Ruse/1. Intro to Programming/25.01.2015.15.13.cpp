/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

71. Зададен е двумерният масив от символни низове А с m реда и n стълба. 
Да се състави програма, която намира най-големия низ във всеки ред.

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>


void largestString(char s1[][30][30], int numberOfRows, int numberOfColumns, char result[][30]){

	int i, j, m = numberOfRows, n = numberOfColumns;
	
	for (i = 0; i < m; i++){
		strcpy_s(result[i], "\0");
		for (j = 0; j < n; j++){
			if (strcmp(s1[i][j], result[i]) == 1) { strcpy_s(result[i], s1[i][j]); }
		}
		
	}
}



// Главна функция
void main(){
	system("chcp 1251");

	int i, j, m, n;
	char A[30][30][30];
	char stringMax[30][30];

	cout << "Enter m: "; cin >> m; cin.ignore();
	cout << "Enter n: "; cin >> n; cin.ignore(); cout << endl;

	for (i = 0; i < m; i++){
		cout << endl << i << " ред: " << endl;
		for (j = 0; j < n; j++){
			cout << "- A[" << i << "][" << j << "]: "; cin.getline(A[i][j], 30);
		}
	}

	cout << endl;

	// Извикване на функцията
	largestString(A, m, n, stringMax);

	for (i = 0; i < m; i++)
	{
		cout << "Най-големият низ на " << i << " ред е: " << stringMax[i] << endl;
	}


	_getch();
}