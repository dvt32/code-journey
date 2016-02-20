/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

3. Да се напише програма, която 
въвежда от клавиатурата текст 
до срещане на предварително зададен символ за край на текста 
и преброява въведените интервали.

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

	char s[101];
	int i = 0;
	int brIntervals = 0;

	cout << "Въведи низ (Enter за край): "; cin.getline(s, 100);

	while (s[i])
	{
		if (s[i] == ' ') brIntervals++;
		i++;
	} 

		cout << "Броят на интервалите е " << brIntervals << "." << endl;
	

	

	_getch();
}