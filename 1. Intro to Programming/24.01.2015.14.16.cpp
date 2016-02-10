/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*


39. Даден е двумерен масив А с m реда и n стълба. Да се състави програма, която създава нов масив а0, а1,...,аm-1, като стойността на аi е равна на 
средно-аритметичното на положителните елементи в i-ия ред.


*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>

void arrayAvgPositive(int array1[][30], int numberOfRows, int numberOfColumns, double *arrayResult){
	
	int m = numberOfRows;
	int n = numberOfColumns;
	int i, j;
	double br[30],		// br - масив с броя положителни елементи на всеки ред
			sum[30],	// sum - масив със сумата на положителните елементи на всеки ред
			avg[30];	// avg - масив със средно-аритметичното на положителните елементи във всеки ред

	for (i = 0; i < m; i++){
		br[i] = 0;
		sum[i] = 0;
		for (j = 0; j < n; j++){
			if (array1[i][j] > 0) { 
				sum[i] += array1[i][j];
				br[i]++; }
		}
		avg[i] = sum[i] / br[i];
		arrayResult[i] = avg[i];
	}
}

// Главна функция
void main(){
	system("chcp 1251");

	int m, n, i, j, A[30][30];
	double a[30];

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
	arrayAvgPositive(A, m, n, a);


	for (i = 0; i < m; i++){
		cout << "a[" << i << "]: " << a[i] << endl;
	}





	_getch();
}