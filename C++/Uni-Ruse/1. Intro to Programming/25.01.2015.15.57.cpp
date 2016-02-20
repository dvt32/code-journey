/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*


2. Дадени са два масива a и b, които съдържат катетите на m правоъгълни триъгълници. 
Да се намери номера на триъгълника с най-голямо лице. 
Да се разработи подпрограма за намиране на лице на правоъгълен триъгълник по зададени катети.

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>


// Функция за намиране на лице на правоъгълен триъгълник по дадени катети
double triangleFace(double katet1, double katet2)
{
	double face = (katet1 * katet2) / 2;
	return face;
}

// Функция за намиране на номера на триъгълника с най-голямо лице.
int faceMaxInd(double *array1, int numberOfTriangles)
{
	int i, maxface_ind = 0, m = numberOfTriangles;
	double maxface = 0.0;
	for (i = 0; i < m; i++)
	{
		if (array1[i] > maxface) { maxface = array1[i]; maxface_ind = i; }
	}
	return maxface_ind;
}

// Главна функция
void main(){
	system("chcp 1251");

	int i, m;
	double a[30], b[30], face[30];

	cout << "Enter m: "; cin >> m; cout << endl;

	for (i = 0; i < m; i++){
		cout << endl;
		cout << i << " триъгълник, катет 1: "; cin >> a[i];
		cout << i << " триъгълник, катет 2: "; cin >> b[i];
		face[i] = triangleFace(a[i], b[i]);
		cout << "Лице: " << face[i] << endl;
	}
	cout << endl;

	cout << "Триъгълник " << faceMaxInd(face, m) << " има най-голямо лице." << endl;
	
	_getch();
}