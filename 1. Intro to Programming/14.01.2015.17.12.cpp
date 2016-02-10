/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

5) Дадени са два масива a и b, 
които съдържат оценките на n студенти 
по два предмета. 

Да се намери номера на студента с най-висок успех 
и броя на студентите, 
които нямат двойки по някой от тези предмети.

*/


#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>

void main(){
	system("chcp 1251");

	int i, n, brBezDvoiki = 0;
	cout << "Enter n: "; cin >> n; cout << endl;

	double *a = new double[n];		// Оценките на студент по Предмет 1
	double *b = new double[n];		// Оценките на студент по Предмет 2
	double *avg = new double[n];	// Среден успех на студент

	double avg_max = 0.0;					// Най-висок среден успех.
	double avg_max_ind = 0;					// Номер на студента с най-висок среден успех.

	for (i = 0; i < n; i++){
		cout << "Студент " << i << ", оценка по Предмет 1: "; cin >> a[i];
		cout << "Студент " << i << ", оценка по Предмет 2: "; cin >> b[i];
		if (a[i] >= 3 && a[i] <= 6 && b[i] >= 3 && b[i] <= 6) { brBezDvoiki++; }
		avg[i] = (a[i] + b[i]) / 2;
		cout << "Среден успех: " << avg[i] << endl << endl;
		if (avg[i] > avg_max){
			avg_max = avg[i];
			avg_max_ind = i;
		}
	}

	cout << endl << brBezDvoiki << " студенти нямат 2-ки и по двата предмета." << endl;
	cout << "Студент " << avg_max_ind << " има най-висок успех (" << avg_max << ")." << endl;

	delete[]a;
	delete[]b;
	delete[]avg;




	_getch();
	

	
}