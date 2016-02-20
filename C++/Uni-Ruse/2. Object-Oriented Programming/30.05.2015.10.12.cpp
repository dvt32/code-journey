

﻿/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

// Задача 4.6

/* 

	В една библиотека се съхраняват в двоичен файл данни за:
		- книгата (заглавие, цена, обем, година на издаване)
		- автора (име, адрес, телефон)
		- издателството (име, адрес, телефон)
	Да се състави програма, която изпълнява от меню следните операции:
		- добавя към файла данните на поредна книга, нейния автор и издателството, което я е издало;
		- извежда всички въведени данни;
		- извежда сумата от цените на книгите от зададен автор и зададено издателство;
		- създава двоичен файл с всички данни на книгите от зададен автор;
		- създава текстов файл с данните на всички книги

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

// Базови класове
class Avtor{
	protected:
		char avtorIme[50], avtorAdres[50], avtorTel[15];
	public:
		void cinInfo(){
			cout << "Име на автора: "; cin.getline(avtorIme, 50);
			cout << "Адрес на автора: "; cin.getline(avtorAdres, 50);
			cout << "Телефон на автора: "; cin.getline(avtorTel, 15);
		}
		void coutInfo(){
			cout << "Име на авторa: " << avtorIme << endl;
			cout << "Адрес на автора: " << avtorAdres << endl;
			cout << "Телефон на автора: " << avtorTel << endl;
		}
};

class Izdatelstvo{
	protected:
		char izdIme[50], izdAdres[50], izdTel[15];
	public:
		void cinInfo(){
			cout << "Име на издателството: "; cin.getline(izdIme, 50);
			cout << "Адрес на издателството: "; cin.getline(izdAdres, 50);
			cout << "Телефон на издателството: "; cin.getline(izdTel, 15);
		}
		void coutInfo(){
			cout << "Име на издателството: " << izdIme << endl;
			cout << "Адрес на издателството: " << izdAdres << endl;
			cout << "Телефон на издателството: " << izdTel << endl << endl;
		}
};


// Производен клас
class Kniga : public Avtor, public Izdatelstvo{
	protected:
		char zaglavie[50];
		double cena;
		int obem, godina;

	public:
		void cinInfo();
		void coutInfo();

		// Деклрариране на функциите като приятели за да имат достъп до член-данните на базовите класове
		friend double sumCeniKnigi(char*, Kniga);
		friend void binTxtKnigi(char*, Kniga);
		friend void binAvtor(char*, Kniga);

		// Подразбиращ се конструктор
		Kniga(){};
		
};

// Функция за въвеждане на данни
void Kniga::cinInfo(){
	cin.ignore();
	// Данни за книгата
	cout << "Заглавие на книга: "; cin.getline(zaglavie, 50);
	cout << "Цена: "; cin >> cena;
	cout << "Обем: "; cin >> obem;
	cout << "Година на издаване: "; cin >> godina; cin.ignore();
	// Данни за автора
	Avtor::cinInfo();
	// Данни за издателството
	Izdatelstvo::cinInfo();
	
}

// Функция за извеждане на данни
void Kniga::coutInfo(){
	// Данни за книгата
	cout << "Заглавие на книга: " << zaglavie << endl;
	cout << "Цена: " << cena << " лв." << endl;
	cout << "Обем: " << obem << " страници" << endl;
	cout << "Година на издаване: " << godina << endl;
	// Данни за автора
	Avtor::coutInfo();
	// Данни за издателството
	Izdatelstvo::coutInfo();
	
}

// Фунцкия за операция 1 от менюто (добавяне на данни в двоичен файл)
void binAdd(char* fileIme, Kniga A){
	fout.open(fileIme, ios::app|ios::binary);
	A.cinInfo();
	fout.write((char*) &A, sizeof(A));
	fout.close();
}

// Функция за операция 2 от менюто (извеждане на всички данни)
void binCout(char* fileIme, Kniga A){
	fin.open(fileIme, ios::in | ios::binary);
	while (fin.read((char*) &A, sizeof(A))){
		A.coutInfo();
	}
	fin.close();
}

// Функция за операция 3 от менюто (извеждане на сумата на цените на книгите от зададен автор/издателство)
double sumCeniKnigi(char* fileIme, Kniga A){
	cin.ignore();

	char findAvtorIme[50], findIzdIme[50];
	cout << "Въведи име на търсения автор: "; cin.getline(findAvtorIme, 50);
	cout << "Въведи име на търсеното издателство: "; cin.getline(findIzdIme, 50);

	double sum = 0;

	fin.open(fileIme, ios::in|ios::binary);
	while (fin.read((char*) &A, sizeof(A))){
		if (strcmp(findAvtorIme, A.avtorIme) == 0 && strcmp(findIzdIme, A.izdIme) == 0){
			sum += A.cena;
		}
	}
	fin.close();

	return sum;
}

// Функция за операция 4 от менюто (създаване двоичен файл с книгите от зададен автор)
void binAvtor(char* fileIme, Kniga A){
	cin.ignore();

	char novBinFile[50];
	cout << "Въведи име на новия двоичен файл: "; cin.getline(novBinFile, 50);

	char findAvtorIme[50];
	cout << "Въведи име на търсения автор: "; cin.getline(findAvtorIme, 50);

	fin.open(fileIme, ios::in | ios::binary);
	fout.open(novBinFile, ios::out|ios::binary);
	while (fin.read((char*) &A, sizeof(A))){
		if (strcmp(findAvtorIme, A.avtorIme) == 0){
			fout.write((char*) &A, sizeof(A));
		}
	}
	fout.close();
	fin.close();
}

// Функция за операция 5 от менюто (създаване текстов файл с данните на всички книги)
void binTxtKnigi(char* fileIme, Kniga A){
	cin.ignore();

	char novTxtFile[50];
	cout << "Въведи име на текстовия файл: "; cin.getline(novTxtFile, 50);

	fin.open(fileIme, ios::in|ios::binary);
	fout.open(novTxtFile, ios::out);
	while (fin.read((char*) &A, sizeof(A))){
		fout << "Заглавие на книга: " << A.zaglavie << endl;
		fout << "Цена: " << A.cena << " лв." << endl;
		fout << "Обем: " << A.obem << " страници" << endl;
		fout << "Година на издаване: " << A.godina << endl << endl;
	}
	fout.close();
	fin.close();
}



// Главна функция
void main(){
	system("chcp 1251");

	char binFile[30];
	cout << endl << "Въведи име на главния двоичен файл: "; cin.getline(binFile, 30);

	int menuCode;
	Kniga A;

	do{
		cout << endl << "МЕНЮ: " << endl;
		cout << "- [1] Добави към двоичния файл данни за книга/автор/издателство" << endl;
		cout << "- [2] Изведи всички въведени данни" << endl;
		cout << "- [3] Изведи сума от цените на книгите от зададен автор и зададено издателство" << endl;
		cout << "- [4] Създай двоичен файл с всички данни на книгите от зададен автор" << endl;
		cout << "- [5] Създай текстов файл с данните на всички книги" << endl;

		cout << endl << "Въведи номер на операцията или 0 за край: "; cin >> menuCode; cout << endl;

		switch (menuCode){
			case 0: break;
			case 1: binAdd(binFile, A); break;
			case 2: binCout(binFile, A); break;
			case 3: cout << endl << "Сумата е равна на " << sumCeniKnigi(binFile, A) << " лв." << endl; break;
			case 4: binAvtor(binFile, A); break;
			case 5: binTxtKnigi(binFile, A); break;
			default: break;
		}
	} while (menuCode != 0);

}


