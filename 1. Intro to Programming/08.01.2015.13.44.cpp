/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*


9. Даден е двумерен масив А с m реда и n стълба. 
Да се състави програма, която създава нов масив а0, а1,...,аm-1, 
като стойността на аi е равна на средно-аритметичното на отрицателните елементи в i-ия ред.

*/


#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>

void main(){
	system("chcp 1251");

	int A[30][30], m, n;
	double a[30];
	int i, j;

	double sum[30];
	int br[30];
	double avg[30];

	cout << "Enter m: "; cin >> m;
	cout << "Enter n: "; cin >> n;

	for (i = 0; i < m; i++){
		sum[i] = 0;
		br[i] = 0;
		cout << endl << i << " ред: " << endl;
		for (j = 0; j < n; j++){
			cout << "- A[" << i << "][" << j << "]: "; cin >> A[i][j];
			if (A[i][j] < 0) { 
				br[i]++;
				sum[i] += A[i][j];
				avg[i] = sum[i] / br[i];
			}
		}
		
	}

	cout << endl;

	for (i = 0; i < m; i++){
		cout << "Средно-аритметично на отрицателните елементи на " << i << " ред: " << avg[i] << endl;
	}





	_getch();
}