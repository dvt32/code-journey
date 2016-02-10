/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

25. Зададен е двумерен масив А с m реда n стълба, съдържащ ЕГН-та на група лица. 
Да се състави програма, която намира най-възрастното лице в целия двумерен масив.

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

	char A[30][30][11], godina_s[30][3], mesec_s[30][3];
	
	int a[30][30], godina[30][30], mesec[30][30],
		i, j, m, n;

	cout << "Enter m: "; cin >> m;
	cout << "Enter n: "; cin >> n; cin.ignore(); cout << endl;

	for (i = 0; i < m; i++){
		cout << endl << i << " ред: " << endl;
		for (j = 0; j < n; j++){
			cout << "- A[" << i << "][" << j << "] (ЕГН): "; cin.getline(A[i][j], 11);
			// Отделяне на годината
			strncpy_s(godina_s[i], A[i][j], 2);
			godina[i][j] = 1900 + atoi(godina_s[i]);
			// Отделяне на месеца и корекция за родените след 1999 г.
			strncpy_s(mesec_s[i], A[i][j] + 2, 2);
			mesec[i][j] = atoi(mesec_s[i]);
			if (mesec[i][j] > 40){
				mesec[i][j] -= 40;
				godina[i][j] += 100;
			}

			}
	}

	cout << endl;

	for (i = 0; i < m; i++){
		cout << endl << i << " ред: " << endl;
		for (j = 0; j < n; j++){
			cout << "- a[" << i << "][" << j << "] (година на раждане): " << godina[i][j] << " г." << endl;
		}
	}



	

	_getch();
}