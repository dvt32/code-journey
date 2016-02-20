﻿/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*

Задача 1. Да се състави програма за нуждите на супермаркет, която съхранява в масив следните данни за всяка стока:
-	стоков номер - низ до 6 знака;
-	наименование - низ до 30 знака;
-	цена - реално число;
-	налично количество - цяло число

и следните данни за фирмата-производител на стоката:
-	фирмен номер  - низ до 6 знака;
-	наименование на фирмата - низ до 30 знака;
-	адрес на фирмата - низ до 30 знака;
-	телефон за връзка - низ до 10 знака

Извършва следните операции:
-	добавя към масива горните данни за доставена стока;
-	извежда всички данни, които се съдържат в масива;
-	изтрива от масива данните за изчерпани стоки;
-	извежда списък с данните на производителите на посочена стока;
-	създава масив с данните на производители на стоки, с цена под 10 лв.

*/


#include "stdafx.h" 
using namespace std;
#include <iostream> 
#include <conio.h> 
#include <stdlib.h> 

// Клас Производител 
class Proizvoditel{
public:
	char FirmNom[9], Naimenovanie[31], Adres[21], Tel[11];

	void getData();
	void display();
};

// Член-функцията getData на класа Proizvoditel 
void Proizvoditel::getData(){
	cin.ignore();
	cout << "Фирма: " << endl;
	cout << "- Фирмен номер: "; cin.getline(FirmNom, 9);
	cout << "- Наименование на фирмата: "; cin.getline(Naimenovanie, 30);
	cout << "- Адрес на фирмата: "; cin.getline(Adres, 21);
	cout << "- Телефон за връзка: "; cin.getline(Tel, 11);
};

// Член-функцията display на класа Proizvoditel  
void Proizvoditel::display(){
	cout << "Фирма: " << endl;
	cout << "- Фирмен номер: " << FirmNom << endl;
	cout << "- Наименование на фирмата: " << Naimenovanie << endl;
	cout << "- Адрес на фирмата: " << Adres << endl;
	cout << "- Телефон за връзка: " << Tel << endl << endl;
};

// Клас Stoka 
class Stoka :public Proizvoditel{
public:
	char StokNom[7], StokaName[31];
	double price;
	int quantityLeft;

	void getData();
	void display();
};

// Член-функцията getData на класа Stoka  
void Stoka::getData(){
	cout << "\nСтоков номер: "; cin.getline(StokNom, 7);
	cout << "Наименование на стоката: "; cin.getline(StokaName, 31);
	cout << "Цена: "; cin >> price;
	cout << "Налично количество: "; cin >> quantityLeft;
	Proizvoditel::getData();
}

// Член-функцията display на класа Stoka  
void Stoka::display(){
	cout << "\nСтоков номер: " << StokNom << endl;
	cout << "Наименование на стоката: " << StokaName << endl;
	cout << "Цена: " << price << endl;
	cout << "Налично количество: " << quantityLeft << endl;
	Proizvoditel::display();
}

// Функция, изтриваща данните  на изчерпаните стоки  
void IztrStoka(int &br, Stoka stoki[]){
	char stokNomIztr[7];//Стоков номер на стоката за изтриване 
	cout << "\nСтоков номер на стоката за изтриване: "; cin >> stokNomIztr;
	for (int i = 0; i<br; i++)
	if (strcmp(stoki[i].StokNom, stokNomIztr) == 0){
		stoki[i] = stoki[i+1];
		br--;
		if (i == br-2) br--;
		return;
	}
	cout << "Грешен регистрационен номер!\n";
}

// Функция, извеждаща данните на производителите на посочена стока 
void SpisProStok(Stoka stoki[], int br){
	char stokNomProv[31];

	cout << "\nВъведи наименование на стоката: "; cin.getline(stokNomProv, 31);

	for (int i = 0; i < br; ++i){
		if (strcmp(stoki[i].StokaName, stokNomProv) == 0)
		{
			cout << "\nСтока: " << stoki[i].StokaName << " (стоков номер: " << stoki[i].StokNom << ")" << endl;
			cout << "Фирма: " << stoki[i].Naimenovanie << endl;
			cout << "Фирмен номер: " << stoki[i].FirmNom << endl;
			cout << "Адрес на фирмата: " << stoki[i].Adres << endl;
			cout << "Телефон на фирмата: " << stoki[i].Tel << endl << endl;
		}
	}
}

//Ф-ия за създаване на масив с данните на производителите на стоки с цена под 10 лв 
void SzdMasPro(Stoka stoki[], int brSt, Proizvoditel proiz[], int &brPro){

	brPro = 0; 
	for (int i = 0, j = 0; i < brSt; ++i){
		if (stoki[i].price < 10){
			brPro++;
			strcpy_s(proiz[j].Naimenovanie, stoki[i].Naimenovanie);
			strcpy_s(proiz[j].FirmNom, stoki[i].FirmNom);
			strcpy_s(proiz[j].Adres, stoki[i].Adres);
			strcpy_s(proiz[j].Tel, stoki[i].Tel);
			j++;
		}
	}
}

//Главна функция main 
void main(){
	system("chcp 1251");
	char KodOp; int i, BrSt = 0; Stoka Stoki[10];
	Proizvoditel Proiz[10]; int BrPro;

	do {
		cout << "\nМЕНЮ НА ИЗПЪЛНЯВАНИТЕ ОПЕРАЦИИ:\n";
		cout << "  1 - за дoбавяне данни за нова стока\n";
		cout << "  2 - за извеждане данните на всички стоки\n";
		cout << "  3 - за изтриване на изчерпана стока;\n";
		cout << "  4 - извежда списък с данните на производиелите на посочена стока;\n";
		cout << "  5 - създава масив с данните на производителите на стоки с цена под 10 лв.;\n";
		cout << "Посочете операция или 0 за край: "; cin >> KodOp; cin.ignore();
		switch (KodOp) {
		case '0':break;
		case '1':Stoki[BrSt++].getData();
			break;
		case '2':cout << "\nСписък на всички стоки:\n";
			for (i = 0; i<BrSt; i++) Stoki[i].display(); break;
		case '3':IztrStoka(BrSt, Stoki);
			break;
		case '4': SpisProStok(Stoki, BrSt);
			break;
		case '5':SzdMasPro(Stoki, BrSt, Proiz, BrPro);
			cout << "\nДанни на производителите на стоки с цена под 10 лв:\n\n";
			for (i = 0; i<BrPro; i++) Proiz[i].display();
			break;
		default: cout << "Грешен код на операция.\n";
		}
	} while (KodOp != '0');
}