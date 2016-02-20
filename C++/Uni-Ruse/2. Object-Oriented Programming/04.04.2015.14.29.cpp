

﻿/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*

8. В една аптека всяко лекарство (наименование, цена, срок на годност) е доставено от доставчик
	- производител (име, адрес, телефон) или от 
	- вносител (име, адрес, телефон).
 
Данните за всяко лекарство, неговия доставчик и производител/вносител се съхраняват в масив.

Да се състави програма, която изпълнява от меню следните операции:
- добавя към масива данните на ново лекарство;
- извежда всички въведени данни;
- извежда данните за най-евтиното лекарство, внесено от посочен вносител;
- извежда данните за всички лекарства с цена над 12 лева, произведени от посочен производител;
- създава масив с данните на всички производители.

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <string>
#include <stdlib.h>
#include <conio.h>

// Клас за производителите (базов на myDrugstore)
class myProducer { protected: char prodName[50], prodAddress[50], prodTel[15]; };

// Клас за вносителите (базов на myDrugstore)
class myImporter { protected: char impName[50], impAddress[50], impTel[15]; };

// Клас за аптеката (производен на myProducer и myImporter)
class myDrugstore : public myProducer, public myImporter
{
protected:
	char drugName[50];
	double drugPrice;
	int drugExpDay, drugExpMonth, drugExpYear;
	bool prodOrImp; // лекарството идва от производителя (0) или от вносителя (1)?
public:
	void cinInfo();
	void coutInfo();
	void findCheapestDrugFromProducer(myDrugstore[], int);
	void findAllDrugsWithPriceAbove12(myDrugstore[], int);
	void createProdArray(myDrugstore[], int, myDrugstore[], int&);
};

// Функция за въвеждане на данните за всяко лекарство
void myDrugstore::cinInfo()
{
	
	cin.ignore();
	// Данни за лекарството
	cout << "\nЛекарство: " << endl;
	cout << "- Наименование: "; cin.getline(drugName, 50);
	cout << "- Цена: "; cin >> drugPrice; cin.ignore();
	cout << "- Срок на годност" << endl;
	cout << "\t- година: "; cin >> drugExpYear;
	cout << "\t- месец: "; cin >> drugExpMonth;
	cout << "\t- ден: "; cin >> drugExpDay; cin.ignore();
	cout << "- Доставчик (производител - 0 или вносител - 1): "; cin >> prodOrImp; cin.ignore();
	prodName[0] = NULL; // предварителна инициализация на името на производителя (нужно на функцията createProdArr)
	// Данни за производителя/вносителя, според въведената стойност за prodOrImp
	if (prodOrImp == 0)
	{
		cout << "Производител: " << endl;
		cout << "- Име: "; cin.getline(prodName, 50);
		cout << "- Адрес: "; cin.getline(prodAddress, 50);
		cout << "- Телефон: "; cin.getline(prodTel, 15);
	}
	if (prodOrImp == 1)
	{
		cout << "Вносител: " << endl;
		cout << "- Име: "; cin.getline(impName, 50);
		cout << "- Адрес: "; cin.getline(impAddress, 50);
		cout << "- Телефон: "; cin.getline(impTel, 15);
	}
}

// Функция за извеждане на данните на всяко лекарство
void myDrugstore::coutInfo(){
	// Данни за лекарството
	cout << "\nЛекарство: " << endl;
	cout << "- Наименование: " << drugName << endl;
	cout << "- Цена: " << drugPrice << endl;
	cout << "- Срок на годност" << endl;
	cout << "\t- година: " << drugExpYear << " г." << endl;
	cout << "\t- месец: " << drugExpMonth << endl;
	cout << "\t- ден: " << drugExpDay << endl;
	// Данни за производителя/вносителя, според въведената стойност за prodOrImp
	if (prodOrImp == 0)
	{
		cout << "Производител: " << endl;
		cout << "- Име: " << prodName << endl;
		cout << "- Адрес: " << prodAddress << endl;
		cout << "- Телефон: " << prodTel << endl << endl;
	}
	if (prodOrImp == 1)
	{
		cout << "Вносител: " << endl;
		cout << "- Име: " << impName << endl;
		cout << "- Адрес: " << impAddress << endl;
		cout << "- Телефон: " << impTel << endl << endl;
	}
}

// Функция за извеждане на данните на най-евтиното лекарство от даден вносител
void myDrugstore::findCheapestDrugFromProducer(myDrugstore drugstoreOne[], int numberOfDrugs){

	char searchImporter[50];				// търсен вносител
	double cheapestDrugPrice = INT_MAX;		// цена на най-евтиното лекарство от този вносител
	int cheapestDrugPriceInd;				// индекс на най-евтиното лекарство от този вносител

	cout << "\nВъведи име на вносител: "; 
	cin.ignore(); cin.getline(searchImporter, 50); cout << endl;

	for (int i=0; i < numberOfDrugs; ++i) 
	{ 
		if (strcmp(drugstoreOne[i].impName, searchImporter) == 0)
		{
			if (drugstoreOne[i].drugPrice < cheapestDrugPrice)
			{
				cheapestDrugPrice = drugstoreOne[i].drugPrice;
				cheapestDrugPriceInd = i;
			}
		}
	}

	if (cheapestDrugPrice == INT_MAX) return; // В случай че нямаме съвпадение между търсен вносител и въведен вносител

	drugstoreOne[cheapestDrugPriceInd].coutInfo();
}

// Функция за извеждане на данните на всички лекарства с цена над 12 лв. от даден производител
void myDrugstore::findAllDrugsWithPriceAbove12(myDrugstore drugstoreOne[], int numberOfDrugs){

	char searchProducer[50];				// търсен производител

	cout << "\nВъведи име на производител: "; cin.ignore(); cin.getline(searchProducer, 50); cout << endl;

	for (int i=0; i < numberOfDrugs; ++i) 
	{ 
		if (strcmp(drugstoreOne[i].prodName, searchProducer) == 0 && drugstoreOne[i].drugPrice > 12)
		{
			drugstoreOne[i].coutInfo();
		}
	}
}

// Функция за създаване на масив с данните на всички производители
void myDrugstore::createProdArray(myDrugstore drugstoreOne[], int numberOfDrugs, myDrugstore prodArray[], int &numberOfProd){

	for (int i = 0, j = 0; i < numberOfDrugs; ++i){
		if (drugstoreOne[i].prodName[0] != NULL) 
		{ 
			strcpy_s(prodArray[j].prodName, drugstoreOne[i].prodName);
			strcpy_s(prodArray[j].prodAddress, drugstoreOne[i].prodAddress);
			strcpy_s(prodArray[j].prodTel, drugstoreOne[i].prodTel);
			j++;
			numberOfProd++;
		}
	}

	for (int i = 0; i < numberOfProd; ++i){
		cout << "Производител: " << endl;
		cout << "- Име: " << prodArray[i].prodName << endl;
		cout << "- Адрес: " << prodArray[i].prodAddress << endl;
		cout << "- Телефон: " << prodArray[i].prodTel << endl << endl;
	}
}

void main(){
	system("chcp 1251");

	int menuCode,							// код на менюто
		i,									// брояч
		numberOfDrugs = 0,					// брой лекарства
		numberOfProd = 0;					// брой производители (за опция 5)

	myDrugstore 
		drugstoreOne[30],					// масив от обекти за аптеката
		prodArray[30];						// масив от обекти за производителите

	do
	{
		cout << endl << "МЕНЮ: \n";
		cout << "- [1] Въведи данни за ново лекарство" << endl;
		cout << "- [2] Изведи данните за всички лекарства" << endl;
		cout << "- [3] Изведи данните за най-евтиното лекарство, внесено от посочен вносител" << endl;
		cout << "- [4] Изведи данните за всички лекарства с цена над 12 лева, произведени от посочен производител" << endl;
		cout << "- [5] Създай масив с данните на всички производители." << endl;

		cout << endl << "Въведи номер на операцията или 0 за край: "; cin >> menuCode; cout << endl;

		switch (menuCode)
		{
		case 0: break;
		case 1: 
			cout << endl << "---" << endl;
			drugstoreOne[numberOfDrugs++].cinInfo();
			cout << "---" << endl;
			break;
		case 2: 
			cout << endl << "---" << endl;
			for (i = 0; i < numberOfDrugs; ++i) { drugstoreOne[i].coutInfo(); }
			cout << "---" << endl;
			break;
		case 3: 
			cout << endl << "---" << endl;
			drugstoreOne[i].findCheapestDrugFromProducer(drugstoreOne, numberOfDrugs);
			cout << "---" << endl;
			break;
		case 4: 
			cout << endl << "---" << endl;
			drugstoreOne[i].findAllDrugsWithPriceAbove12(drugstoreOne, numberOfDrugs);
			cout << "---" << endl;
			break;
		case 5: 
			cout << endl << "---" << endl;
			prodArray[i].createProdArray(drugstoreOne, numberOfDrugs, prodArray, numberOfProd);
			cout << "---" << endl;
			break;
		default: break;
		}
	} while (menuCode != 0);

	_getch();
}

