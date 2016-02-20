/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

12. Зададен е едномерният масив от ЕГН-та E0, E1,..., En-1 
Да се състави програма, която създава нов масив а0, а1,...,аn-1, 
като стойността на аi е равна на годината на раждане на лицето с ЕГН Ei.

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

	char E[30][11], godina[3], mesec[3];

	int a[30], i, j, n;

	cout << "Enter n: "; cin >> n; cin.ignore();
	cout << endl;
	
	for (i = 0; i < n; i++){
		cout << "E[" << i << "]: "; cin.getline(E[i], 11);
		strncpy_s(godina, E[i], 2);
		strncpy_s(mesec, E[i] + 2, 2); 
		// за родените след 1999 към месеца се прибавя числото 40.
		if (atoi(mesec) > 12) {
			a[i] = 2000 + atoi(godina);
		}
		else { a[i] = 1900 + atoi(godina); }
		
	}

	cout << endl;

	for (i = 0; i < n; i++){
		cout << "a[" << i << "]: " << a[i] << endl; 
	}


	_getch();
}