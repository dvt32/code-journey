

﻿/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*

10. В една аптека всяко лекарство (наименование, цена, срок на годност) е доставено от:
- доставчик (име, адрес, телефон),
- от производител (име, адрес, телефон) или от вносител (име, адрес, телефон). 

Данните за всяко лекарство, неговия доставчик и производител/вносител се съхраняват в масив.

Да се състави програма, която изпълнява от меню следните операции:
- добавя към масива данните на ново лекарство;
- извежда всички въведени данни;
- извежда данните на производителите, с които работи определен доставчик;
- създава масив с данните на лекарствата, внасяни от посочен вносител;
- създава масив с данните на всички вносители, внасящи посочено лекарство.

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <string>
#include <stdlib.h>
#include <conio.h>

// Kлас за доставчиците (базов на myDrugstore)
class myProvider { protected: char provName[50], provAddress[50], provTel[15]; };

// Клас за производителите (базов на myDrugstore)
class myProducer { protected: char prodName[50], prodAddress[50], prodTel[15]; };

// Клас за вносителите (базов на myDrugstore)
class myImporter { protected: char impName[50], impAddress[50], impTel[15]; };

// Клас за аптеката (производен на myProducer и myImporter)
class myDrugstore : public myProvider, public myProducer, public myImporter
{
protected:
	char drugName[50];
	double drugPrice;
	int drugExpDay, drugExpMonth, drugExpYear;
	bool prodOrImp; // лекарството идва от производителя (0) или от вносителя (1)?
public:
	void cinInfo();
	void coutInfo();
	void findProducersOfProvider(myDrugstore[], int);
	void createDrugArray(myDrugstore[], int, myDrugstore[], int&);
	void createImpArray(myDrugstore[], int, myDrugstore[], int&);
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
	// Данни за доставчика
	cout << "Доставчик: " << endl;
	cout << "- Име: "; cin.getline(provName, 50);
	cout << "- Адрес: "; cin.getline(provAddress, 50);
	cout << "- Телефон: "; cin.getline(provTel, 15);
	cout << "- От производител (0) или вносител (1): "; cin >> prodOrImp; cin.ignore();
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
	// Данни за доставчика
	cout << "Доставчик: " << endl;
	cout << "- Име: " << provName << endl;
	cout << "- Адрес: " << provAddress << endl;
	cout << "- Телефон: " << provTel << endl;
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

// Функция за извеждане данните на производителите, с които работи определен доставчик
void myDrugstore::findProducersOfProvider(myDrugstore drugstoreOne[], int numberOfDrugs){

	char searchProvider[50];					// търсен доставчик

	cout << "\nВъведи име на доставчик: ";
	cin.ignore(); cin.getline(searchProvider, 50); cout << endl;

	for (int i = 0; i < numberOfDrugs; ++i)
	{
		if (drugstoreOne[i].prodOrImp == 0 && strcmp(drugstoreOne[i].provName, searchProvider) == 0)
		{
			cout << "Производител: " << endl;
			cout << "- Име: " << drugstoreOne[i].prodName << endl;
			cout << "- Адрес: " << drugstoreOne[i].prodAddress << endl;
			cout << "- Телефон: " << drugstoreOne[i].prodTel << endl << endl;
		}
	}
}

// Функция за създаване на масив с данните на лекарствата, внасяни от посочен вносител
void myDrugstore::createDrugArray(myDrugstore drugstoreOne[], int numberOfDrugs, myDrugstore drugArr[], int &numberOfDrugsByImp){

	char searchImporter[50];				// търсен вносител

	cout << "\nВъведи име на вносител: "; cin.ignore(); cin.getline(searchImporter, 50); cout << endl;

	for (int i = 0, j = 0; i < numberOfDrugs; ++i)
	{
		if (drugstoreOne[i].prodOrImp == 1 && strcmp(drugstoreOne[i].impName, searchImporter) == 0)
		{
			drugArr[j] = drugstoreOne[i];
			numberOfDrugsByImp++;
			j++;
		}
	}
}

// Функция за създаване на масив с данните на всички вносители, внасящи посочено лекарство
void myDrugstore::createImpArray(myDrugstore drugstoreOne[], int numberOfDrugs, myDrugstore impArray[], int &numberOfImp){

	char searchDrug[50];					// търсено лекарство

	cout << "\nВъведи име на лекарство: ";
	cin.ignore(); cin.getline(searchDrug, 50); cout << endl;

	for (int i = 0, j = 0; i < numberOfDrugs; ++i){
		if (drugstoreOne[i].prodOrImp == 1 && strcmp(drugstoreOne[i].drugName, searchDrug) == 0)
		{
			strcpy_s(impArray[j].prodName, drugstoreOne[i].impName);
			strcpy_s(impArray[j].prodAddress, drugstoreOne[i].impAddress);
			strcpy_s(impArray[j].prodTel, drugstoreOne[i].impTel);
			j++;
			numberOfImp++;
		}
	}

	for (int i = 0; i < numberOfImp; ++i){
		cout << "Производител: " << endl;
		cout << "- Име: " << impArray[i].prodName << endl;
		cout << "- Адрес: " << impArray[i].prodAddress << endl;
		cout << "- Телефон: " << impArray[i].prodTel << endl << endl;
	}

	numberOfImp = 0; // в случай, че искаме да използваме функцията отново
}

void main(){
	system("chcp 1251");

	int menuCode,							// код на менюто
		i,									// брояч
		numberOfDrugs = 0,					// брой лекарства
		numberOfDrugsByImp = 0,				// брой лекарства от даден вносител (за опция 4)
		numberOfImp = 0;					// брой вносители (за опция 5)

	myDrugstore
		drugstoreOne[30],					// масив от обекти за аптеката
		drugArr[30],						// масив от обекти за опция 4 от менюто
		impArr[30];							// масив от обекти за опция 5 от менюто

	do
	{
		cout << endl << "МЕНЮ: \n";
		cout << "- [1] Въведи данни за ново лекарство" << endl;
		cout << "- [2] Изведи данните за всички лекарства" << endl;
		cout << "- [3] Изведи данните на производителите, с които работи определен доставчик" << endl;
		cout << "- [4] Създай масив с данните на лекарствата, внасяни от посочен вносител" << endl;
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
			drugstoreOne[i].findProducersOfProvider(drugstoreOne, numberOfDrugs);
			cout << "---" << endl;
			break;
		case 4:
			cout << endl << "---" << endl;
			drugArr[i].createDrugArray(drugstoreOne, numberOfDrugs, drugArr, numberOfDrugsByImp);
			for (i = 0; i < numberOfDrugsByImp; ++i) { drugArr[i].coutInfo(); }
			numberOfDrugsByImp = 0; // в случай, че искаме да използваме функцията отново, но по-късно
			cout << "---" << endl;
			break;
		case 5:
			cout << endl << "---" << endl;
			impArr[i].createImpArray(drugstoreOne, numberOfDrugs, impArr, numberOfImp);
			cout << "---" << endl;
			break;
		default: break;
		}
	} while (menuCode != 0);

	_getch();
}

