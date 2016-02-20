/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/* 6) Дадени са 
два масива a и b, 
които съдържат оценките на n студенти по два предмета. 
Да се намери номера на студента с най-висок успех 
и броя на студентите, които нямат двойки.
 */


#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>

void main(){
	system("chcp 1251");

	int a[30], b[30], i;
	int n;
	int brBezDvoiki = 0;

	double avg = 0.0;
	double maxAvg = 0.0;
	int ind_maxAvg;
	

	cout << "Брой студенти: "; cin >> n; cout << endl;

	for (i = 0; i < n; i++){
		cout << "Студент " << i << ", оценка 1: "; cin >> a[i];
		cout << "Студент " << i << ", оценка 2: "; cin >> b[i];
		cout << endl;
		if (a[i] > 2 && a[i] <= 6 &&
			b[i] > 2 && b[i] <= 6)
		{
			brBezDvoiki++;
		}
	}
	
	cout << "Броят на студентите без 2-ки и по двата предмета е " << brBezDvoiki;

	for (i = 0; i < n; i++){
		avg = (a[i] + b[i]) / 2;
		if (avg > maxAvg) { maxAvg = avg; ind_maxAvg = i; }
	}

	cout << endl << "Номерът на студента с най-висок среден успех е " << ind_maxAvg << " (среден успех: " << maxAvg << ")";
	

	_getch();
}