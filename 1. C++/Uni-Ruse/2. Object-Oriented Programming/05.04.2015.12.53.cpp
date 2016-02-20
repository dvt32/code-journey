

﻿/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*

9. В една аптека всяко лекарство (наименование, цена, срок на годност) е доставено от доставчик:
- от производител (име, адрес, телефон) или от 
- вносител (име, адрес, телефон). 

Данните за всяко лекарство и неговия производител/вносител се съхраняват в масив.

Да се състави програма, която изпълнява от меню следните операции:
- добавя към масива данните на ново лекарство;
- извежда всички въведени данни;
- извежда данните на производителите на посочено лекарство;
- създава масив с данните за лекарствата с цена под 5 лв, произведени от посочен производител;
- създава масив с данните на всички производители, доставящи посочено лекарство.

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
	void findProducerOfDrug(myDrugstore[], int);
	void createDrugArray(myDrugstore[], int, myDrugstore[], int&);
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

// Функция за извеждане на данните на производителя на дадено лекарство
void myDrugstore::findProducerOfDrug(myDrugstore drugstoreOne[], int numberOfDrugs){

	char searchDrug[50];					// търсено лекарство

	cout << "\nВъведи име на лекарство: ";
	cin.ignore(); cin.getline(searchDrug, 50); cout << endl;

	for (int i = 0; i < numberOfDrugs; ++i)
	{
		if (strcmp(drugstoreOne[i].drugName, searchDrug) == 0)
		{
			cout << "Производител: " << endl;
			cout << "- Име: " << drugstoreOne[i].prodName << endl;
			cout << "- Адрес: " << drugstoreOne[i].prodAddress << endl;
			cout << "- Телефон: " << drugstoreOne[i].prodTel << endl << endl;
		}
	}
}

// Функция за създаване на масив с данните за лекарствата с цена под 5 лв, произведени от посочен производител
void myDrugstore::createDrugArray(myDrugstore drugstoreOne[], int numberOfDrugs, myDrugstore drugArr[], int &numberOfDrugsByProd){

	char searchProducer[50];				// търсен производител

	cout << "\nВъведи име на производител: "; cin.ignore(); cin.getline(searchProducer, 50); cout << endl;

	for (int i = 0, j = 0; i < numberOfDrugs; ++i)
	{
		if (strcmp(drugstoreOne[i].prodName, searchProducer) == 0 && drugstoreOne[i].drugPrice < 5)
		{
			drugArr[j] = drugstoreOne[i];
			numberOfDrugsByProd++;
			j++;
		}
	}
}

// Функция за създаване на масив с данните на всички производители, доставящи посочено лекарство.
void myDrugstore::createProdArray(myDrugstore drugstoreOne[], int numberOfDrugs, myDrugstore prodArray[], int &numberOfProd){

	char searchDrug[50];					// търсено лекарство

	cout << "\nВъведи име на лекарство: ";
	cin.ignore(); cin.getline(searchDrug, 50); cout << endl;

	for (int i = 0, j = 0; i < numberOfDrugs; ++i){
		if (strcmp(drugstoreOne[i].drugName, searchDrug) == 0 && drugstoreOne[i].prodOrImp == 0)
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
		numberOfDrugsByProd = 0,			// брой лекарства от даден производител (за опция 4)
		numberOfProd = 0;					// брой производиители (за опция 5)

	myDrugstore
		drugstoreOne[30],					// масив от обекти за аптеката
		drugArr[30],						// масив от обекти за опция 4 от менюто
		prodArr[30];						// масив от обекти за опция 5 от менюто

	do
	{
		cout << endl << "МЕНЮ: \n";
		cout << "- [1] Въведи данни за ново лекарство" << endl;
		cout << "- [2] Изведи данните за всички лекарства" << endl;
		cout << "- [3] Изведи данните на производителите на посочено лекарство" << endl;
		cout << "- [4] Създай масив с данните за лекарствата с цена под 5 лв, произведени от посочен производител" << endl;
		cout << "- [5] Създай масив с данните на всички производители, доставящи посочено лекарство" << endl;

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
			drugstoreOne[i].findProducerOfDrug(drugstoreOne, numberOfDrugs);
			cout << "---" << endl;
			break;
		case 4:
			cout << endl << "---" << endl;
			drugArr[i].createDrugArray(drugstoreOne, numberOfDrugs, drugArr, numberOfDrugsByProd);
			for (i = 0; i < numberOfDrugsByProd; ++i) { drugArr[i].coutInfo(); }
			numberOfDrugsByProd = 0; // в случай, че искаме да използваме функцията отново, но по-късно
			cout << "---" << endl;
			break;
		case 5:
			cout << endl << "---" << endl;
			prodArr[i].createProdArray(drugstoreOne, numberOfDrugs, prodArr, numberOfProd);
			cout << "---" << endl;
			break;
		default: break;
		}
	} while (menuCode != 0);

	_getch();
}

