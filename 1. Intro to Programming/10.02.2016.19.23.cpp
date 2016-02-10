/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/* 
2) Да се състави програма, която по въведени ръбове a, b, c на правоъгълен паралелепипед, извежда повърхнината и обемът му.
*/


#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>

void main(){
	system("chcp 1251");

	double a;
	double b;
	double c;
	cout << "Enter 'a': "; cin >> a;
	cout << "Enter 'b': "; cin >> b;
	cout << "Enter 'c': "; cin >> c;

	double V = a*b*c;
	cout << endl << "V: " << V << " cm3.";

	double S = 2 * (a + b)*c;
	double B = V / c;
	double S1 = S + 2 * B;
	cout << endl << "S: " << S;
	cout << endl << "S1:  " << S1;


	_getch();
}