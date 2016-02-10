

﻿/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*

Задача 1.

3.3. Да се състави програма за туристическа агенция, която поддържа следните данни за своите клиенти: 
- име - низ до 20 знака; 
- ЕГН - низ от 10 знака; 
- телефон - низ от 10 знака; 
- месечен доход- реално число; 
- желана страна за посещение - низ до25 знака; 

и извършва следните операции, избирани от меню: 
- създава празен файл; 
- добавя данните на нови клиенти-туристи; 
- извежда на екрана данните на жените, желаещи да посетят посочена страна;  
- създава текстов файл с имената и датите на раждане на жените с телефонни номера, започващи с 088; 
- създава двоичен файл с данните на клиентите мъже с месечен доход над 1000 лв.. 


*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <fstream>
#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string>

ifstream fin; ofstream fout; 

class Tourist{
	protected:
		char name[21], EGN[11], phone[11], country[26];
		double monthlyIncome;

	public:
		void cinInfo();
		void coutInfo();

		friend void binCreate(string);
		friend void binAdd(string, Tourist);
};

// Функция за въвеждане на данни за даден клиент
void Tourist::cinInfo(){
	cin.ignore();
	cout << "Име: "; cin.getline(name, 21);
	cout << "ЕГН: "; cin.getline(EGN, 11);
	cout << "Телефон: "; cin.getline(phone, 11);
	cout << "Месечен доход: "; cin >> monthlyIncome; cin.ignore();
	cout << "Страна: "; cin.getline(country, 26);
}

// Функция за извеждане на данни за 
void Tourist::coutInfo(){
	cout << "Име: " << name << endl;
	cout << "ЕГН: " << EGN << endl;
	cout << "Телефон: " << phone << endl;
	cout << "Месечен доход: " << monthlyIncome << " лв." << endl;
	cout << "Страна: " << country << endl;
}

// Функция за създаване на празен двоичен файл
void binCreate(string fileName){
	fout.open(fileName, ios::out|ios::binary); fout.close();
}

// Функция за добавяне на данни в двоичния файл
void binAdd(string fileName, Tourist obj){
	fout.open(fileName, ios::app|ios::binary);
	obj.cinInfo();
	fout.write((char*) &obj, sizeof(obj));
}



//Главна функция main
void main(){
	system("chcp 1251");

	string mainBinFile;

	int menuCode, i;

	Tourist tourObj;

	cout << endl << "Име на главния двоичен файл: "; getline(cin, mainBinFile); cout << endl;

	do {
		cout << endl << "МЕНЮ: " << endl;
		cout << "[1] Създай празен двоичен файл" << endl;
		cout << "[2] Добави данните на нови клиенти-туристи";
		cout << "[3] Изведи на екрана данните на жените, желаещи да посетят посочена страна";
		cout << "[4] Създай текстов файл с имената и датите на раждане на жените с телефонни номера, започващи с 088";
		cout << "[5] Създай двоичен файл с данните на клиентите мъже с месечен доход над 1000 лв.";

		cout << endl << "Посочете операция или 0 за край: "; cin >> menuCode; cout << endl;

		switch (menuCode){
		case 0: break;
		case 1: binCreate(mainBinFile); break;
		case 2: Dobaviane(); break;
		case 3:
			cout << "Име на двоичния файл: "; cin >> GlDvFl;
			Fl_EkranTxtFl(GlDvFl, A);
			break;
		case 4:
			cout << "Име на двоичния файл: "; cin >> GlDvFl;
			Fl_EkranTxtFl(GlDvFl, A, fout);
			break;
		case 5:Iztrivane(); break;
		default: cout << "\n\nГрешен код на операция!\n\n\a";
		}
	} while (KodOp != '0');

}

