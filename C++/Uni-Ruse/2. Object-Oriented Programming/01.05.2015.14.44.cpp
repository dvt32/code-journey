
/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*

1.1. Да се състави програма, която с данните за лекарствата в една аптека:
- наименование - низ до 20 знака;
- цена - реално число;
- налично количество - цяло число;
- дата, до която е годно за употреба

извършва следните действия, избирани от меню:
- създава празен двоичен файл;
- добавя към файла данни за лекарство;
- извежда на екрана данните на лекарствата с цена до 10 лв;
- създава двоичен файл с данните на лекарствата, годни до определена дата;
- създава текстов файл с имената и цените на лекарствата с налично количество до 50 бр.

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <fstream>
#include <stdio.h>
#include <stdlib.h>
#include <conio.h>

ifstream fileRead; ofstream fileWrite;

class Drugstore{
protected:
	char name[20];
	double price;
	int quantity, expDay, expMonth, expYear;
public:
	void cinInfo();
	void coutInfo();
	Drugstore(){};
	friend void binCoutPrice(char*, Drugstore);
	friend void binCreateExpDate(Drugstore, char*, char*);
	friend void txtCreate(Drugstore, char*, char*);
};

// Функция за въвеждане на данните за лекарство
void Drugstore::cinInfo(){
	cin.ignore();

	cout << "Име на лекарство: "; cin.getline(name, 20);
	cout << "Цена: "; cin >> price;
	cout << "Налично количество: "; cin >> quantity;
	cout << "Срок на годност: " << endl;
	cout << "- ден: "; cin >> expDay;
	cout << "- месец: "; cin >> expMonth;
	cout << "- година: "; cin >> expYear;
}

// Функция за извеждане на данните на лекарство
void Drugstore::coutInfo(){
	cout << "Име на лекарство: " << name << endl;
	cout << "Цена: " << price << " лв." << endl;
	cout << "Налично количество: " << quantity << " бр." << endl;
	cout << "Срок на годност: " << expDay << "." << expMonth << "." << expYear << " г." << endl;
	cout << endl;
}

// Функция за създаване на празен двоичен файл
void binCreate(char* fileName){
	fileWrite.open(fileName, ios::out | ios::binary);
	fileWrite.close();
}

// Функция за добавяне на данни за лекарство в двоичния файл
void binAdd(char *fileName, Drugstore drug){
	fileWrite.open(fileName, ios::app | ios::binary);
	drug.cinInfo();
	fileWrite.write((char*)&drug, sizeof(drug));
	fileWrite.close();
}

// Функция за извеждане на екрана данните на лекарства с цена до 10 лв.
void binCoutPrice(char *fileName, Drugstore drug){
	fileRead.open(fileName, ios::in | ios::binary);
	while (fileRead.read((char*)&drug, sizeof(drug))){
		if (drug.price <= 10) { drug.coutInfo(); }
	}
	fileRead.close();
}

// Функция за създаване на двоичен файл, с данните на лекарствата, годни до определена дата
void binCreateExpDate(Drugstore drug, char *fileNameInput, char *fileNameOutput){
	int D, M, Y, dateCompare;

	cout << endl << "Въведи дата: " << endl;
	cout << "- ден: "; cin >> D;
	cout << "- месец: "; cin >> M;
	cout << "- година: "; cin >> Y;


	fileRead.open(fileNameInput, ios::in | ios::binary);
	fileWrite.open(fileNameOutput, ios::app | ios::binary);
	while (fileRead.read((char*)&drug, sizeof(drug))){

		if (Y != drug.expYear) dateCompare = Y - drug.expYear;
		else if (M != drug.expMonth) dateCompare = M - drug.expMonth;
		else dateCompare = D - drug.expDay;

		if (dateCompare < 0){
			fileWrite.write((char*)&drug, sizeof(drug));
		}

	}
	fileWrite.close();
	fileRead.close();
}

// Функция за създаване на текстов файл с имената и цените на лекарствата с налично количество до 50 бр.
void txtCreate(Drugstore A, char *binFile, char *txtFile){
	fileRead.open(binFile, ios::in | ios::binary);
	fileWrite.open(txtFile, ios::app);
	while (fileRead.read((char*)&A, sizeof(A))){
		if (A.quantity <= 50){
			fileWrite << "Име на лекарството: " << A.name << endl;
			fileWrite << "Цена: " << A.price << " лв." << endl << endl;
		}
	}
	fileWrite.close();
	fileRead.close();
}

//Главна функция main
void main(){
	system("chcp 1251");

	int menuCode;

	char fileName[50], fileNameExpDate[50], txtFileName[50];

	cout << endl << "Въведи име на двоичния файл: "; cin.getline(fileName, 50);

	Drugstore myDrug;

	do{
		cout << endl << "МЕНЮ: " << endl;
		cout << "- [1] Създай празен двоичен файл" << endl;
		cout << "- [2] Добави към файла данни за лекарство" << endl;
		cout << "- [3] Изведи на екрана данните на лекарствата с цена до 10 лв." << endl;
		cout << "- [4] Създай двоичен файл с данните на лекарствата, годни до определена дата" << endl;
		cout << "- [5] Създай текстов файл с имената и цените на лекарствата с налично количество до 50 бр." << endl;

		cout << endl << "Въведи номер на операцията или 0 за край: "; cin >> menuCode; cout << endl;

		switch (menuCode){
		case 0:break;
		case 1:
			binCreate(fileName);
			cout << "Операцията е изпълнена." << endl;
			break;
		case 2:
			binAdd(fileName, myDrug);
			break;
		case 3:
			binCoutPrice(fileName, myDrug);
			break;
		case 4:
			cin.ignore(); cout << "Въведи име на двоичния файл: "; cin.getline(fileNameExpDate, 50);
			binCreateExpDate(myDrug, fileName, fileNameExpDate);
			cout << endl << "Операцията е изпълнена." << endl;
			break;
		case 5:
			cin.ignore(); cout << "Въведи име на текстовия файл: "; cin.getline(txtFileName, 50);
			txtCreate(myDrug, fileName, txtFileName);
			cout << "Операцията е изпълнена." << endl;
			break;
		default:break;
		}
	} while (menuCode != 0);

}