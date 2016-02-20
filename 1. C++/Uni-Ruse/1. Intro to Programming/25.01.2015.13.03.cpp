/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

57. Зададен е масив от символни низове А0, А1,...,Аn-1. 
Да се състави прог-рама, която създава масива а0, а1,...,аn-1, като стойността на аi=0, 
ако в Аi няма еднакви съседни символи, и аi=1, ако в Аi има еднакви съседни сим-воли.

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>

void stringHasEqualNeighborCharacters(char array1[][30], int numberOfElements, bool *array2){

	int i, j = 0, n = numberOfElements;
	bool hasEqualNeighbourCharacters[30];	// Има ли низ i равни съседни символи (0 - не, 1 - да)

	for (i = 0; i < n; i++){
		hasEqualNeighbourCharacters[i] = 0;
		for (j = 0; j < strlen(array1[i]) - 1; j++){ // -1, за да може да се използва A[i][j+1]
			if (array1[i][j] == array1[i][j + 1] ||
				array1[i][j] == array1[i][j - 1])
			{
				hasEqualNeighbourCharacters[i] = 1; break;
			}
		}
		array2[i] = hasEqualNeighbourCharacters[i];
	}
}



// Главна функция
void main(){
	system("chcp 1251");

	char A[30][30];
	bool a[30];
	int i, n;

	cout << "Enter n: "; cin >> n; cin.ignore(); cout << endl;

	for (i = 0; i < n; i++){
		cout << "A[" << i << "]: "; cin.getline(A[i], 30);
	}

	cout << endl;

	// Извикване на функцията
	 stringHasEqualNeighborCharacters(A, n, a);

	for (i = 0; i < n; i++){
		cout << "a[" << i << "]: " << a[i] << endl;
	}



	_getch();
}