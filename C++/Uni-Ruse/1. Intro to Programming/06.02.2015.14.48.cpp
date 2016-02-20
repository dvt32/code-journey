/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <string>

// Дефиниране на функцията Bira
void Bira(int n){

	if (n > 1) Bira(n - 1);
	// 1. n = 3, затова извикваме Bira(n - 1);
    // 2. (намираме се в 1-вoто извикване на Bira(n-1)) n = 2, затова извикваме пак Bira(n-1);
    // 3. (намираме се във 2-рото извикване на Bira(n-1) n = 1, затова
			// cout << "Донесете " << 1 << " бира/и, моля." << endl;
	// 4. Излизаме от 2-рото извикване на Bira(n-1), n = 2 и затова
			// cout << "Донесете " << 2 << " бира/и, моля." << endl;
	// 5. Излизаме от 1-вото извикване на Bira(n-1), n = 3 и затова
			// cout << "Донесете " << 3 << " бира/и, моля." << endl;

	cout << "Донесете " << n << " бира/и, моля." << endl;
}
// Дефиниране на функцията main
void main(){
	system("chcp 1251");

	int N = 3; Bira(N);

	_getch();
}