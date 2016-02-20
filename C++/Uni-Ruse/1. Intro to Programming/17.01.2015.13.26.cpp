/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

6. Да се състави програма, 
която проверява, 
дали два зададени символни низа са еднакви.

*/


#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>

void main()
{
	system("chcp 1251");

	char s1[30];
	char s2[30];
	int stringCompare;

	int i = 0, brSymbol = 0;

	cout << "Enter string 1: "; cin >> s1;
	cout << "Enter string 2: "; cin >> s2;

	stringCompare = strcmp(s1, s2);

	/* 
	-отрицателно цяло число, когато str1<str2;
	-положително цяло число, когато str1>str2;
	-нула, когато str1=str2;
	*/
 
	if (stringCompare == 1) { cout << "string 1 > string 2" << endl; }
	if (stringCompare == 0) { cout << "Двата низа са равни." << endl; }
	if (stringCompare == -1) { cout << "string 2 > string 1" << endl; }



	_getch();
}