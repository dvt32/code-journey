/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

// Най-неразбираемия ми код до този момент...

/*  
11) 
Даден е масивът а0, а1,..., аn-1, 
подреден в нарастващ ред, и променливата b. 
Да се разшири масива с един елемент равен на стойността на b, без да се нарушава подреждането на масива.
 */


#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>

void main(){
	system("chcp 1251");

	int a[30], b, n, i;

	cout << "Enter n: "; cin >> n;
	cout << "Enter b: "; cin >> b; cout << endl;

	for (i = 1; i < n+1; i++){
		cout << "Enter element number " << i << ": "; cin >> a[i];
		if (a[i - 1] > a[i]) { cout << "Елементите не са във възходящ ред." << endl; return; }
	}

	cout << endl;

	for (i = 1; i < n+1; i++){
		if (a[i] >= b) { a[0] = b; cout << "Елемент " << i << ": " << a[0] << endl; break; }
		cout << "Елемент " << i << ": " << a[i] << endl;
		}

		cout << "Елемент " << ++i << ": " << a[i-1] << endl;

	for (++i; i < n + 2; i++){
			cout << "Елемент " << i << ": " << a[i-1] << endl;
		}

	
	
	

	_getch();
}