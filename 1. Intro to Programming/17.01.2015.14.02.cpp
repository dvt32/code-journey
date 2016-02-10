/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

4. Да се състави програма, която преброява изреченията в зададен символен низ, като се има предвид, че изреченията завършват с точка, въпросителен знак или удивителен
знак.

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

	int i = 0, brSentences = 0;

	cout << "Enter string 1: "; cin.getline(s, 80);

	while (s[i] != '\0'){
		if (s[0] != '.' && s[0] != '!' && s[0] != '?');
		if ((i != 0) && (s[i] == '.' || s[i] == '!' || s[i] == '?')) { brSentences++; }
		i++;
}

cout << "Брой изречения в низа: " << brSentences << endl;



	_getch();
}