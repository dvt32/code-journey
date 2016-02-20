/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

14. Зададен е едномерният масив от ЕГН-та E0, E1,..., En-1 
Да се състави програма, която създава нов масив а0, а1,...,аn-1, 
като стойността на аi е 0, ако Ei е ЕГН на мъж, или 1, ако Ei е ЕГН на жена.

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

	// Ако предпоследната цифра на ЕГН-то е 
	// четна -> МЪЖ   /  нечетна --> ЖЕНА

	char E[30][11], gender_s[30][2]; // gender_s[] -> string
	int a[30], gender[30], // gender[] - преобразуване на gender_s[] в int
		i, j, n;

	cout << "Enter n: "; cin >> n; cin.ignore();
	cout << endl;

	for (i = 0; i < n; i++){
		cout << "E[" << i << "]: "; cin.getline(E[i], 11);
		strncpy_s(gender_s[i], E[i] + 8, 1);
		gender[i] = atoi(gender_s[i]);
	}

	cout << endl;

	for (i = 0; i < n; i++){
		if (gender[i] % 2 == 0){ a[i] = 0; } // мъж
		if (gender[i] % 2 == 1){ a[i] = 1; } // жена
		cout << "a[" << i << "]: " << a[i] << endl;
	}


	_getch();
}