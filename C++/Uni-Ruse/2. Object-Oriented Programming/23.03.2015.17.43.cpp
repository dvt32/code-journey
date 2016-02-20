/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*

Задача 2. В прогрaма за библиотека:

1. Всяка книга се описва със следните данни :
-инв.номер;
-автор;
-заглавие;
-цена;

2. Всеки читател се описва със следните данни :
-име на читателя;
-адрес на читателя;
-ЕГН на читателя.

3. Всяко даване на книга на читател се записва в регистъра на раздадените книги със следните данни :
-регистрационен номер на операцията даване на книга;
-дата на връщане на книгата.

Програмата съхранява данните в масив и извършва следните операции :
-дoбавя към масива горните данни за книга, дадена на читател;
-извежда всички данни, които се съдържат в масива;
-изтрива от масива данните за върната книга;
-извежда списък с данните на читателите, невърнали книги в срок;
-създава масив с данните на книгите, невърнати в срок.

В упражнение 8 са създадени два базови класа и един производен клас. 
Новата задача е да добавите към всеки от тези класове 
по два конструктора. 
- Единият да инициализира всички членове на съответния клас, 
- а другият – само част от тях.

*/

#include "StdAfx.h"
using namespace std;
#include <iostream>
#include <string.h>
#include <stdlib.h>
#include <conio.h>

// Клас Kniga
class Kniga{
public:
	char InvNom[7], Avtor[21], Zaglavie[76];
	float Cena;
	
	Kniga(){};												// Подразбиращ се конструктор
	Kniga(char[], char[], char[], float);					// Конструктор, инициализиращ всички член-данни на Kniga
	Kniga(char*, float);									// Конструктор, инициализиращ някои член-данни (не се използва)

	void display(); //Прототип на член-функцията display
};

// Конструктор, инициализиращ всички член-данни на Kniga
Kniga::Kniga(char invNom[], char author[], char title[], float price){
	strcpy_s(InvNom, invNom);
	strcpy_s(Avtor, author);
	strcpy_s(Zaglavie, title);
	Cena = price;
}

// Конструктор, инициализиращ някои член-данни (InvNom, Cena) - не се използва в програмата
Kniga::Kniga(char *invNom, float price){ strcpy_s(InvNom, invNom); Cena = price; }

// Член-функцията display на класа Kniga
void Kniga::display(){
	cout << "\nИнвентарен номер: " << InvNom << endl;
	cout << "Автор: " << Avtor << endl;
	cout << "Заглавие: " << Zaglavie << endl;
	cout << "Цена: " << Cena << " лв." << endl;
}

// Клас Lice
class Lice{
protected:
	char Ime[21], Adres[51], EGN[11];
public:
	Lice(){};								// Подразбиращ се конструктор
	Lice(char[], char[], char[]);		    // Конструктор, инициализиращ всички член-данни на Lice
	Lice(char[], char[]);					// Конструктор, инициализиращ някои член-данни (не се използва)

	void display();
};

// Конструктор, инициализиращ всички член-данни на Lice и Kniga
Lice::Lice(char name[], char address[], char egn[]){
	strcpy_s(Ime, name);
	strcpy_s(Adres, address);
	strcpy_s(EGN, egn);
}

// Конструктор, инициализиращ някои член-данни на Lice (не се ползва)
Lice::Lice(char name[], char egn[]) { strcpy_s(Ime, name); strcpy_s(EGN, egn); }

// Член-функцията display на класа Lice
void Lice::display(){
	cout << "Име на лицето: " << Ime << endl;
	cout << "Адрес на лицето: " << Adres << endl;
	cout << "ЕГН на лицето: " << EGN << endl;
}

// Клас DMG
class DMG{
public:
	int D, M, G; //Член-данни на класа DMG
	void getData(); //Прототип на член-функцията getData
	void display();//Прототип на член-функцията display
};

// Дефиниция на член-функцията getData от класа DMG
void DMG::getData(){
	
}

// Дефиниция на член-функцията display от класа DMG
void DMG::display(){
	cout << D << '.' << M << '.' << G << endl;
}

// Функция за сравняване на дати
int datcmp(DMG D1, DMG D2){
	if (D1.G != D2.G) return D1.G - D2.G;
	if (D1.M != D2.M) return D1.M - D2.M;
	return D1.D - D2.D;
}

// Клас Registar
class Registar : public Kniga, public Lice {
public:
	char RegNom[16];
	DMG DatVr; //Дата връщане на книгата

	Registar(){};								// Подразбиращ се конструктор
	Registar									// Конструктор, инициализиращ всички член-данни на Kniga, Lice, Registar
		(char[], char[], char[], float,					// член-данни на Kniga
		 char[], char[], char[],						// член-данни на Lice
		 char[], int, int, int							// член-данна на Registar + член-данни на DMG
		);
	Registar(char*);							// Конструктор, инициализиращ само член-данната на Registar (не се използва)


	void display(); //Прототип на член-функцията display
};

// Конструктор, инициализиращ всички член-данни на Kniga, Lice, Registar
Registar::Registar
   (char invNom[], char author[], char title[], float price,			// Kniga
	char name[], char address[], char egn[],							// Lice
	char regNom[], int d, int m, int g)									// Registar + DMG
	: Kniga(invNom, author, title, price), Lice(name, address, egn)
{
	strcpy_s(RegNom, regNom);
	DatVr.D = d;
	DatVr.M = m;
	DatVr.G = g;
}

// Конструктор, инициализиращ само член-данната на Registar (не се използва)
Registar::Registar(char *regNom) { strcpy_s(RegNom, regNom); }

// Член-функцията display на класа Registar
void Registar::display(){
	Kniga::display();
	Lice::display();
	cout << "Регистрационен номер: " << RegNom << endl;
	cout << "Дата за връщане на книгата: "; DatVr.display();
}

// Функция, изтриваща върнатите книги от масива
void IztriKni(int &br, Registar dk[]){
	char regNomIztr[7];//Рег. номер на книгата за изтриване
	DMG currentDate; // Обект за текущата дата
	int dateCompare; // Резултат от функцията datcmp

	cout << "\nВъведи текущата дата: \n";
	cout << "- ден: "; cin >> currentDate.D;
	cout << "- месец: "; cin >> currentDate.M;
	cout << "- година: "; cin >> currentDate.G;

	cout << "\nВъведи рег. номер на книга за изтриване: "; cin.ignore(); cin.getline(regNomIztr, 7);
	for (int i = 0; i < br; ++i)
	{
		dateCompare = datcmp(currentDate, dk[i].DatVr);
		if (dateCompare < 0 && strcmp(dk[i].RegNom, regNomIztr) == 0){
			dk[i] = dk[br - 1];
			br--;
		}
	}
	cout << "Операцията приключи." << endl << endl;
}

// Функция, извеждаща данните на лицата, невърнали в срок книги
void SpisNeVarnati(Registar dk[], int br)
{
	DMG KontrDat;	 // Обект за текущата дата
	int dateCompare; // Резултат от функцията datcmp

	cout << "\nВъведи текущата дата: \n"; 
	cout << "- ден: "; cin >> KontrDat.D;
	cout << "- месец: "; cin >> KontrDat.M;
	cout << "- година: "; cin >> KontrDat.G;
	cout << endl;

	for (int i = 0; i < br; ++i)
	{
		dateCompare = datcmp(KontrDat, dk[i].DatVr);
		if (dateCompare > 0) { dk[i].Lice::display(); }
	}
}


//Функция за създаване на масив с данните на читателите, невърнали в срок книги
void SzdMasChit(Registar dk[], int brKn, Kniga books[], int &brChit)
{
	DMG KontrDat;	 // Обект за текущата дата
	int dateCompare; // Резултат от функцията datcmp
	brChit = 0;		 // Нужно инициализиране на brChit

	cout << "\nВъведи текущата дата: \n";
	cout << "- ден: "; cin >> KontrDat.D;
	cout << "- месец: "; cin >> KontrDat.M;
	cout << "- година: "; cin >> KontrDat.G;
	cout << endl;

	for (int i = 0, j = 0; i < brKn; ++i)
	{
		dateCompare = datcmp(KontrDat, dk[i].DatVr);
		if (dateCompare > 0)
		{
			brChit++;
			strcpy_s(books[j].InvNom, dk[i].InvNom);
			strcpy_s(books[j].Avtor, dk[i].Avtor);
			strcpy_s(books[j].Zaglavie, dk[i].Zaglavie);
			books[j].Cena = dk[i].Cena;
			j++;
		}
	}
}


//Главна функция main
void main(){
	system("chcp 1251");
	char KodOp; int i, BrDadKn = 0; Registar DadKni[10];
	Kniga Books[10]; int BrChit;

	// Временни променливи, в които ще бъдат запазени стойности за член-данните на класовете Kniga, Lice, Registar
	char invNom[7], author[21], title[76]; float price;		// Kniga
	char name[21], address[51], egn[11];					// Lice
	char regNom[16]; int d, m, g;							// Registar + DMG


	do {
		cout << "\nМЕНЮ НА ИЗПЪЛНЯВАНИТЕ ОПЕРАЦИИ:\n";
		cout << " 1 - за дoбавяне данни за дадени книги\n";
		cout << " 2 - за извеждане данните на всички раздад. книги.\n";
		cout << " 3 - за изтриване на върната книга;\n";
		cout << " 4 - за списък с данните на читат., невърнали книги;\n";
		cout << " 5 - за създаване масив с данните на невърнат.книги;\n";
		cout << "Посочете операция или 0 за край: "; cin >> KodOp;
		switch (KodOp) {
		case '0': break;
		case '1':
		{
			// Въвеждане на стойности за член-данните на Kniga
			cin.ignore();
			cout << "\nИнвентарен номер: "; cin.getline(invNom, 7);
			cout << "Автор: "; cin.getline(author, 21);
			cout << "Заглавие: "; cin.getline(title, 76);
			cout << "Цена: "; cin >> price;

			// Въвеждане на стойности за член-данните на Lice
			cin.ignore();
			cout << "Име на лицето: "; cin.getline(name, 21);
			cout << "Адрес на лицето: "; cin.getline(address, 51);
			cout << "ЕГН на лицето: "; cin.getline(egn, 11);

			// Въвеждане на стойности за член-данните на Registar
			cout << "Регистрационен номер: "; cin.getline(regNom, 16);
			cout << "Дата за връщане на книгата: \n";
			cout << "- ден: "; cin >> d;
			cout << "- месец: "; cin >> m;
			cout << "- година: "; cin >> g;

			// Използване на конструктора на Registar за инициализиране на всички член-данни
			Registar myObject(invNom, author, title, price, name, address, egn, regNom, d, m, g);
			DadKni[BrDadKn] = myObject;
			BrDadKn++;

			break;
		}
		case '2':
			cout << "\nСписък на всички книги:\n";
			for (i = 0; i<BrDadKn; i++) DadKni[i].display(); break;
		case '3':
			IztriKni(BrDadKn, DadKni);
			break;
		case '4':
			cout << "\nДанни за читателите:\n";
			SpisNeVarnati(DadKni, BrDadKn);
			break;
		case '5':
			SzdMasChit(DadKni, BrDadKn, Books, BrChit);
			cout << "\nДанни на невърнатите книги:\n";
			for (i = 0; i<BrChit; i++) Books[i].display();
			break;
		default: cout << "Грешен код на операция.\n";
		}
	} while (KodOp != '0');
}

