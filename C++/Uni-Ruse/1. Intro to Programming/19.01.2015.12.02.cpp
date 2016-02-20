/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

7. Да се състави програма, която проверява, 
дали зададен символен низ съдържа еднакви съседни символи.

*/


#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>

void main(){
	system("chcp 1251");

	char s[30];
	int i = 0;

	cout << "Enter s: "; cin.getline(s, 30);

	while (s[i] != '\0'){
		if (s[i] == s[i + 1] || s[i] == s[i - 1]) { cout << "Низът съдържа съседни символи.\n"; break; }
		if (s[i + 1] == '\0') { cout << "Низът НЕ съдържа съседни символи.\n"; break; }
		i++;
	}


	_getch();
}