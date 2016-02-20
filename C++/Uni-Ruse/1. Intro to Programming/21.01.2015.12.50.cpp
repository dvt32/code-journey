/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

23. Зададен е двумерният масив от символни низове А с m реда n стъл-ба. 
Да се състави програма, която намира най-големия низ във всеки ред.

*/

// Най-големия != най-дългия (т.е вместо strlen, да се използва strcmp_s)


#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>

void main(){
	system("chcp 1251");

	char A[30][30][101], A_max[30][101];
	int i, j, m, n;

	cout << "Enter m: "; cin >> m;
	cout << "Enter n: "; cin >> n; cin.ignore(); cout << endl;

	for (i = 0; i < m; i++){
		strcpy_s(A_max[i], "\0");
		cout << endl << i << " ред: " << endl;
		for (j = 0; j < n; j++){
			cout << "- A[" << i << "][" << j << "]: "; cin.getline(A[i][j], 101);
			if (strcmp(A[i][j], A_max[i]) == 1){
				strcpy_s(A_max[i], A[i][j]);
			}
		}
	}

	cout << endl;

	for (i = 0; i < m; i++){
		cout << "Най-големият низ на " << i << " ред е " << A_max[i] << "." << endl;
	}



	

	_getch();
}