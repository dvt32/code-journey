/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

8. Да се състави програма, която проверява, 
дали зададен символен низ съдържа всички букви от а до я.

*/


#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>

void main()
{
	system("chcp 1251");

	string s;
	cout << "Enter string: "; cin >> s;

	if (
		(s.find('а') != string::npos || s.find('А') != string::npos) &&
		(s.find('б') != string::npos || s.find('Б') != string::npos) &&	

	    ) // По-същият начин се продължава за следващите букви
	{
		cout << "Низът съдържа всички букви" << endl;
	}
	else cout << "Низът НЕ съдържа всички букви." << endl;


	_getch();
}