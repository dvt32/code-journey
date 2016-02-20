/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*


32. Даден е двумерен масив А с m реда и n стълба. 
Да се състави програма, която създава нов масив а0, а1,...,аm-1, като стойността на аi е 
равна на броя на ненулевитеелементи в i-ия ред.


*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>

void arrayBrNenulevi(int array1[][30], int numberOfRows, int numberOfColumns, int *arrayResult){
	
	int m = numberOfRows;
	int n = numberOfColumns;
	int i, j, br[30];			// br - масив с броя на ненулевите елементи за всеки ред

	for (i = 0; i < m; i++){
		br[i] = 0;
		for (j = 0; j < n; j++){
			if (array1[i][j] != 0) { br[i]++; }
		}
		arrayResult[i] = br[i];
	}
}

// Главна функция
void main(){
	system("chcp 1251");

	int m, n, i, j, A[30][30], a[30];

	cout << "Enter m: "; cin >> m;
	cout << "Enter n: "; cin >> n; cout << endl;

	for (i = 0; i < m; i++){
		cout << endl << i << " ред: " << endl;
		for (j = 0; j < n; j++){
			cout << "- A[" << i << "][" << j << "]: "; cin >> A[i][j];
		}
	}
	
	cout << endl;

	// Извикване на функцията
	arrayBrNenulevi(A, m, n, a);


	for (i = 0; i < m; i++){
		cout << "a[" << i << "]: " << a[i] << endl;
	}





	_getch();
}