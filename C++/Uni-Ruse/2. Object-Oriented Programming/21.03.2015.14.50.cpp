

﻿/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*

Задача 2. Към програмата, дадена по - долу, добавете следните два конструктора:
-конструктор, инициализиращ всички член - данни на класа;
-конструктор, инициализиращ член - данните Zaglavie и Cena.

Да се състави програма, която съхранява в масив следните данни закнигите в една библиотека:
- инвентарен номер - низ до 6 знака;
- автор - низ от 20 знака;
- заглавие - низ до 30 знака;
- обем на книгата (брой страници) - цяло число;
- цена - реално число;

Извършва следните операции:
- създава масива с данните за книгите;
- извежда на екрана данните за всички книги;
- изтрива данните за книга със зададен инв.номер;
- намира и извежда сумата от цените на всички книги;
- за извеждане данните на всички книги от зададен автор;
- създава нов масив с всички данни за книгите с цена до 15 лв.
- създава нов масив съдържащ заглавията и цените на книгите до 150 стр.

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <conio.h>
#include <stdlib.h>

//Клас Kniga
class Kniga{
	char InvNom[7], Avtor[21], Zaglavie[76];
	int Obem;
	float Cena;
public:
	Kniga(){}; // Подразбиращ се конструктор за създаването на масивите от обекти MasKnigi/MasKnigi15 в main функцията
	Kniga(char*, char*, char*, int, float); // Конструктор, инициализиращ всички член-данни на класа.

	void display(); //Прототип на член-функцията display

	// Останалите функции се превръщат в член-функции на класа, за да могат да имат достъп до член-данните
	float SumaCeni(Kniga[], int);
	void KnigiZadAvtot(Kniga[], int, char[]);
	void IztriKni(Kniga[], int &);
	void SzdMas15(Kniga[], int, Kniga[], int &);

	friend class Kniga1; // нужно, за да може функцията SzdNovMas от Kniga1 да има достъп до член-данните на Kniga
};

// Конструктор, инициализиращ всички член-данни на класа.
Kniga::Kniga(char *invNumber, char *author, char *title, int volume, float price)
{
	strcpy_s(InvNom, invNumber);
	strcpy_s(Avtor, author);
	strcpy_s(Zaglavie, title);
	Obem = volume;
	Cena = price;
}

//Член-функцията display на класа Kniga
void Kniga::display(){
	cout << "\nИнвентарен номер: " << InvNom << endl;
	cout << "Автор: " << Avtor << endl;
	cout << "Заглавие: " << Zaglavie << endl;
	cout << "Обем: " << Obem << endl;
	cout << "Цена: " << Cena << endl;
}
//Функция за намиране сумата от цените на всички книги
float Kniga::SumaCeni(Kniga masKnig[], int n){
	float suma = 0;
	for (int i = 0; i<n; i++) suma += masKnig[i].Cena;
	return suma;
}
//Извеждане данните на книгите от зададен автор
void Kniga::KnigiZadAvtot(Kniga masKnig[], int n, char zadAvtor[]){
	for (int i = 0; i<n; i++)
	if (strcmp(masKnig[i].Avtor, zadAvtor) == 0) masKnig[i].display();
}
//Функция за изтриване от масива на посочена книга
void Kniga::IztriKni(Kniga masKnig[], int &n){
	char invNom[7]; int i, k = 0;
	cout << "Въвдете инв. номер на книгата: "; cin >> invNom;
	for (i = 0; i<n; i++)
	if (strcmp(masKnig[i].InvNom, invNom) == 0) break;
	if (i == n){ cout << "Грешен инвeнтарен номер.\n"; return; }
	masKnig[i] = masKnig[n - 1];
	n--;
}
//Функция за създаване на масив с всички данни за книгите с цена до 15 лв.
void Kniga::SzdMas15(Kniga masKnig[], int brKn, Kniga masKnig15[], int &brKn15){
	int j = 0;
	for (int i = 0; i<brKn; i++)
	if (masKnig[i].Cena<15) masKnig15[j++] = masKnig[i];
	brKn15 = j;
}
//Създаване на нов клас, нужен за създаване на масив, съдържащ заглавията и цените на книгие под 150 стр.
class Kniga1{
	char zaglavie[31];
	float cena;
public:
	Kniga1(){}; // Подразбиращ се конструктор за създаването на масив от обекти MasKnigi150 в main функцията
	Kniga1(char*, float); // Конструктор за Zaglavie и Cena

	// SzdNovMas се превръща в член-функция на класа, за да може да има достъп до член-данните
	void SzdNovMas(Kniga[], int, Kniga1[], int &);

	void display(){
		cout << zaglavie << " " << cena << endl;
	}
};

// Конструктор, инициализиращ член-данните Zaglavie и Cena
Kniga1::Kniga1(char *zagl, float tsena){
	strcpy_s(zaglavie, zagl);
	cena = tsena;
}

//Функция за създаване на масив, съдържащ заглавията и цените на книгите под 150 стр.
void Kniga1::SzdNovMas(Kniga masKnig[], int brKn, Kniga1 masKnig150[], int &brKn150){
	
	// Създаване на временни променливи
	char zagl[76];
	float tsena;
	
	// Определяне на стойностите
	int j = 0;
	for (int i = 0; i<brKn; i++)
	if (masKnig[i].Obem<150){
		strcpy_s(zagl, masKnig[i].Zaglavie);
		tsena = masKnig[i].Cena;
		// Използване на конструктора
		Kniga1 resultObject(zagl, tsena);
		masKnig150[j] = resultObject;
		j++;
	}
	brKn150 = j;
}

//Главна функция main
void main(){
	system("chcp 1251");
	char KodOp; int i, BrKn = 0, BrKn15, BrKn150 = 0;
	Kniga MasKnigi[10], MasKnig15[10],
		fCall; // нужен обект за извикване на член-функциите на Kniga
	Kniga1 MasKnig150[10], 
		fCall1; // нужен обект за извикване на член-функциите на Kniga1
	char ZadAvtor[21];
	do {
		cout << "\nМЕНЮ НА ИЗПЪЛНЯВАНИТЕ ОПЕРАЦИИ:\n";
		cout << " 1 - за дoбавяне данни за книгa\n";
		cout << " 2 - за извеждане данните на всички книги.\n";
		cout << " 3 - за намиране и извеждане сумата от цените на всички книги;\n";
		cout << " 4 - за извеждане данните на всички книги от зададен автор;\n";
		cout << " 5 - за изтриване данните на книга със зададен инв.номер;\n";
		cout << " 6 - за създаване на масив с всички данни за книгите с цена до 15 лв.\n";
		cout << " 7 - за създаване на масив, съдържащ заглавията и цените\n"
			<< " на книгите с обем до 150 стр.\n";
		cout << "Посочете операция или 0 за край: "; cin >> KodOp;
		switch (KodOp) {
		case '0':break;
		case '1':
		{
			cin.ignore();

			// Създаване на променливи, в които временно се съдържат въведените данни
			char invnom[7], avtor[21], zaglavie[76];
			int obem;
			float cena;
	
			// Въвеждане на данните, които се съхраняват във временните променливи
			cout << endl << endl;
			cout << "Инвентарен номер: "; cin.getline(invnom, 20);
			cout << "Автор: "; cin.getline(avtor, 20);
			cout << "Заглавие: "; cin.getline(zaglavie, 75);
			cout << "Обем: "; cin >> obem;
			cout << "Цена: "; cin >> cena;

			// Използване на конструктора за прехвърляне на данните от временните променливи в оригиналните променливи в класа
			Kniga resultObject(invnom, avtor, zaglavie, obem, cena);
			MasKnigi[BrKn] = resultObject;
			BrKn++;

			break;
		}
		case '2':cout << "\nСписък на всички кнги:\n";
			for (i = 0; i<BrKn; i++) MasKnigi[i].display(); break;
		case '3':cout << "Сумата от цените на всички книги е "
			<< fCall.SumaCeni(MasKnigi, BrKn) << endl;
			break;
		case '4':cin.ignore();
			cout << "Задайте автора: "; cin.getline(ZadAvtor, 20);
			cout << "\n\tKниги от " << ZadAvtor << ":\n";
			fCall.KnigiZadAvtot(MasKnigi, BrKn, ZadAvtor); break;
		case '5':fCall.IztriKni(MasKnigi, BrKn); break;
		case '6':fCall.SzdMas15(MasKnigi, BrKn, MasKnig15, BrKn15);
			for (i = 0; i<BrKn15; i++) MasKnig15[i].display();
			break;
		case '7':
			fCall1.SzdNovMas(MasKnigi, BrKn, MasKnig150, BrKn150);
			for (i = 0; i<BrKn150; i++) MasKnig150[i].display();
			break;
		default: cout << "Грешен код на операция.\n";
		}
	} while (KodOp != '0');
}

