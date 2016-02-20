/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

55. Зададени са един масив от символни низове А0, А1,...,Аn-1 и един символ В. Да се състави програма, която създава масива а0, а1,...,аn-1, като стой-ността на аi
показва колко пъти се среща B в Аi.

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>

void brSymbolInString(char array1[][30], int numberOfElements, char symbol, int *array2){

	int i, j=0, n = numberOfElements;
	int brSymbol[30];	// Масив, съдържащ броя пъти срещания на даден символ във всеки низ

	for (i = 0; i < n; i++){
		brSymbol[i] = 0;
		for (j = 0; j < strlen(array1[i]); j++){
			if (array1[i][j] == symbol) { brSymbol[i]++; }
		}
		array2[i] = brSymbol[i];
	}

}


// Главна функция
void main(){
	system("chcp 1251");

	char A[30][30];
	char B;
	int a[30], i, n;

	cout << "Enter n: "; cin >> n; cin.ignore();
	cout << "Enter B: "; cin >> B; cin.ignore(); cout << endl;

	for (i = 0; i < n; i++){
		cout << "A[" << i << "]: "; cin.getline(A[i], 30);
	}

	cout << endl;

	// Извикване на функцията
	brSymbolInString(A, n, B, a);

	for (i = 0; i < n; i++){
		cout << "a[" << i << "]: " << a[i] << endl;
	}



	_getch();
}