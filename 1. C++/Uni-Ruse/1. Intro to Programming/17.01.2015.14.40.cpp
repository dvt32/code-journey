/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

5. Да се състави програма, 
която преброява главните букви 
в зададен символен низ, 
съдържащ букви от кирилицата и препинателни знаци.

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

	char s[81];

	int i = 0, brGlavni = 0;

	cout << "Enter string 1: "; cin.getline(s, 80);

	while (s[i] != '\0'){
		if
			(
			(s[i] < 'А' || s[i] > 'я') &&
			( s[i] != ',' &&
			  s[i] != '.' &&
			  s[i] != ':' &&
			  s[i] != ';' &&
			  s[i] != '!' &&
			  s[i] != '-' &&
			  s[i] != '?' &&
			  s[i] != '!' 
			)
		) 
		{
			cout << "Низът съдържа нелегални символи." << endl; return;
		}
		if (s[i] >= 'А' && s[i] <= 'Я') { brGlavni++; }
		i++;
	}

cout << "Брой главни букви на кирилица в низа: " << brGlavni << endl;



	_getch();
}