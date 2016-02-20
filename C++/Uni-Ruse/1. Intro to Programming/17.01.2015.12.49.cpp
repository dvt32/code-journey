/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

1. Да се напише програма, 
която намира колко пъти се среща 
всеки от следните символи “!’, ‘?’, ‘,’, ‘.’, ‘:’, ‘;’ 
в даден низ.

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

	int i = 0;
	int brEM = 0, brQM = 0, brCommas = 0, brFS = 0, brColons = 0, brSC = 0; // Брой ! ? , . : ;
	char s[81];

	cout << "Enter string: "; cin >> s; cout << endl;

	while (s[i] != '\0'){
			if (s[i] == '!') brEM++;
			if (s[i] == '?') brQM++;
			if (s[i] == ',') brCommas++;
			if (s[i] == '.') brFS++;
			if (s[i] == ':') brColons++;
			if (s[i] == ';') brSC++;
			i++;
	}

	cout << "! = " << brEM << endl;
	cout << "? = " << brQM << endl;
	cout << ", = " << brCommas << endl;
	cout << ". = " << brFS << endl;
	cout << ": = " << brColons << endl;
	cout << "; = " << brSC << endl;

	_getch();
}