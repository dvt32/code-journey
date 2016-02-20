/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

20. Зададен е двумерният масив от символни низове А с m реда n стъл-ба. 
Да се състави програма, която 
създава нов двумерен масив а с m реда n стълба, 
като стойността на аij е равна на броя на символите в низа Аij

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

	char A[30][30][101];
	int a[30][30], i, j, m, n;

	cout << "Enter m: "; cin >> m;
	cout << "Enter n: "; cin >> n; cin.ignore(); cout << endl;

	for (i = 0; i < m; i++){
		cout << endl << i << " ред: " << endl;
		for (j = 0; j < n; j++){
			cout << "- A[" << i << "][" << j << "]: "; cin.getline(A[i][j], 101);
		}
	}

	cout << endl << "=== РЕЗУЛТАТ ===" << endl;

	for (i = 0; i < m; i++){
		cout << endl << i << " ред: " << endl;
		for (j = 0; j < n; j++){
			cout << "- A[" << i << "][" << j << "]: " << strlen(A[i][j]) << " символа." << endl;
		}
	}



	

	_getch();
}