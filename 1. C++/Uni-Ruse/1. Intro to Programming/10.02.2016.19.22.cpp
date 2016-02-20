/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/* 
1) Да се състави програма, която по въведени страни a, b на правоъгълен триъгълник, извежда лицето и периметъра на триъгълника.
*/


#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>

void main(){
	system("chcp 1251");

	// a*a + b*b = c*c

	double a;
	double b;
	cout << "Enter 'a': "; cin >> a;
	cout << "Enter 'b': "; cin >> b;

	// c
	double c_by_c = a*a + b*b;
	double c = sqrt(c_by_c);

	double P = a+b+c;
	double S = (a+b)/2;



	cout << endl << "The perimeter of the triangle is " << P << " cm.";
	cout << endl << "The face of the triangle is equal to " << S << " cm2.";


	_getch();
}