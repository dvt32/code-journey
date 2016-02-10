/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

52. Да се състави програма, която проверява, 
дали всеки от два зададени символни низа съдържа еднакви съседни символи.

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>

bool stringEqualNeighborSymbols(char *string1, char *string2){

	int i;
	bool EqualNeighborSymbols_1 = 0; // Има ли съседни равни символи в низ 1 (0 - не, 1 - да)
	bool EqualNeighborSymbols_2 = 0; // Има ли съседни равни символи в низ 2 (0 - не, 1 - да)

	// Проверка за съседни равни символи в низ 1
	for (i = 0; i < strlen(string1); i++){
		if (string1[i] == string1[i - 1] || string1[i] == string1[i + 1])
		{
			EqualNeighborSymbols_1 = 1; break;
		}
	}

	// Проверка за съседни равни символи в низ 2
	for (i = 0; i < strlen(string2); i++){
		if (string2[i] == string2[i - 1] || string2[i] == string2[i + 1])
		{
			EqualNeighborSymbols_2 = 1; break;
		}
	}

	if (EqualNeighborSymbols_1 == 1 && EqualNeighborSymbols_2 == 1) { return 1; }
	if (
		(EqualNeighborSymbols_1 == 1 && EqualNeighborSymbols_2 == 0) ||
		(EqualNeighborSymbols_1 == 0 && EqualNeighborSymbols_2 == 1) ||
		(EqualNeighborSymbols_1 == 0 && EqualNeighborSymbols_2 == 0)
																		) 
	{return 0;}

}


// Главна функция
void main(){
	system("chcp 1251");

	char s1[30], s2[30];

	cout << "Низ 1: "; cin.getline(s1, 30);
	cout << "Низ 2: "; cin.getline(s2, 30); 
	cout << endl;

	bool result = stringEqualNeighborSymbols(s1, s2);
	if (result == 1) { cout << "И двата низа съдържат съседни равни символи." << endl; }
	else
	{
		cout << "Един от двата (или и двата) низа НЕ съдържат съседни равни симоволи." << endl;
	}



	_getch();
}