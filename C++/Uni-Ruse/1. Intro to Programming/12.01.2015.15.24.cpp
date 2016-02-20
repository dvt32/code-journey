/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

7) Да се разменят стойностите на елементите 
с най-голяма и най-малка стойности 
в отделните стълбове на двумерен масив с m реда и n стълба.

*/


#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>

void main(){
	system("chcp 1251");

	int A[30][30];
	int m, n, i, j;

	int maxColumn[30];			// Масив, съдържащ най-голямата стойност на всеки стълб.
	int minColumn[30];			// Масив, съдържащ най-малката стойност на всеки стълб.


	cout << "Enter m: "; cin >> m;
	cout << "Enter n: "; cin >> n;

	// Въвеждане на елементите
	for (i = 0; i < m; i++){

		cout << endl << i << " стълб: " << endl;
		for (j = 0; j < n; j++)
		{
			cout << "- A[" << j << "][" << i << "]: "; cin >> A[j][i];
		}
	}

	cout << endl;

	// Определяне на НМС и НГС по стълб.
	for (i = 0; i < m; i++){

		maxColumn[i] = INT_MIN;
		minColumn[i] = INT_MAX;
		for (j = 0; j < n; j++)
		{
			if (A[j][i] > maxColumn[i]) 
			{ 
				maxColumn[i] = A[j][i]; 
				
			}
			if (A[j][i] < minColumn[i]) 
			{ 
				minColumn[i] = A[j][i]; 
			}
		}
		
	}

	cout << "=== НГС и НМС ===" << endl << endl;

	for (i = 0; i < m; i++){
		cout << i << " стълб: " << endl;
		cout << "- НГС: " << maxColumn[i] << endl;
		cout << "- НМС: " << minColumn[i] << endl;
		cout << endl;
	}

	cout << "=== РАЗМЕНЕНИ СТОЙНОСТИ ===" << endl;

	for (i = 0; i < m; i++){

		cout << endl << i << " стълб: " << endl;
		for (j = 0; j < n; j++)
		{
			if (A[j][i] == maxColumn[i]) 
			{ 
				A[j][i] = minColumn[i]; 
				cout << "- A[" << j << "][" << i << "]: " << A[j][i] << endl; continue;
			}

			if (A[j][i] == minColumn[i])
			{
				A[j][i] = maxColumn[i];
				cout << "- A[" << j << "][" << i << "]: " << A[j][i] << endl; continue;
			}

			if (A[j][i] != maxColumn[i] && A[j][i] != maxColumn[i])
			{
				cout << "- A[" << j << "][" << i << "]: " << A[j][i] << endl;
			}	
		}
	}


	_getch();

	
}