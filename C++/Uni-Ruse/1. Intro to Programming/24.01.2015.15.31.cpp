/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

53. Да се състави програма, която проверява, дали всеки от два зададени символни низа съдържа всички букви от а до я.

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>

bool stringHasAllBulgarianLetters(string string1, string string2){

	bool hasAllBulgarianLetters_1 = 0; // Има ли всички български букви в низ 1 (0 - не, 1 - да)
	bool hasAllBulgarianLetters_2 = 0; // Има ли всички български букви в низ 2 (0 - не, 1 - да)

	// string::npos = дадена буква не е намерена

	// Проверка за всички букви от българската азбука в низ 1
	if (
			((string1.find('а') != string::npos) || (string1.find('А') != string::npos)) &&
			((string1.find('б') != string::npos) || (string1.find('Б') != string::npos)) &&
			((string1.find('в') != string::npos) || (string1.find('В') != string::npos)) &&
			((string1.find('г') != string::npos) || (string1.find('Г') != string::npos))
			// По същия начин за всички следващи букви...
		)
	{
		hasAllBulgarianLetters_1 = 1;
	}

	// Проверка за всички букви от българската азбука в низ 2
	if (
		((string2.find('а') != string::npos) || (string2.find('А') != string::npos)) &&
		((string2.find('б') != string::npos) || (string2.find('Б') != string::npos)) &&
		((string2.find('в') != string::npos) || (string2.find('В') != string::npos)) &&
		((string2.find('г') != string::npos) || (string2.find('Г') != string::npos))
		// По същия начин за всички следващи букви...
		)
	{
		hasAllBulgarianLetters_2 = 1;
	}

	
	if (hasAllBulgarianLetters_1 == 1 && hasAllBulgarianLetters_2 == 1) { return 1; }
	if (
		(hasAllBulgarianLetters_1 == 1 && hasAllBulgarianLetters_2 == 0) ||
		(hasAllBulgarianLetters_1 == 0 && hasAllBulgarianLetters_2 == 1) ||
		(hasAllBulgarianLetters_1 == 0 && hasAllBulgarianLetters_2 == 0)
																		) 
	{return 0;}

}


// Главна функция
void main(){
	system("chcp 1251");

	string s1, s2;

	cout << "Низ 1: "; cin >> s1;
	cout << "Низ 2: "; cin >> s2;
	cout << endl;

	bool result = stringHasAllBulgarianLetters(s1, s2);
	if (result == 1) { cout << "И двата низа съдържат всички български букви." << endl; }
	else
	{
		cout << "Един от двата (или и двата) низа НЕ съдържат всички български букви." << endl;
	}



	_getch();
}