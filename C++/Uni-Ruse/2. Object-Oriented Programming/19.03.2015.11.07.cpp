/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*

Задача 1. В прогрaма за библиотека :
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
	void getData(); //Прототип на член-функцията getData
	void display(); //Прототип на член-функцията display
};

// Член-функцията getData на класа Kniga
void Kniga::getData(){
	cin.ignore();
	cout << "\nИнвентарен номер: "; cin.getline(InvNom, 7);
	cout << "Автор: "; cin.getline(Avtor, 21);
	cout << "Заглавие: "; cin.getline(Zaglavie, 76);
	cout << "Цена: "; cin >> Cena;
}

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
	void getData();
	void display();
};

// Член-функцията getData на класа Lice
void Lice::getData(){
	cin.ignore();
	cout << "Име на лицето: "; cin.getline(Ime, 21);
	cout << "Адрес на лицето: "; cin.getline(Adres, 51);
	cout << "ЕГН на лицето: "; cin.getline(EGN, 11);
}

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
	cout << "- ден: "; cin >> D;
	cout << "- месец: "; cin >> M;
	cout << "- година: "; cin >> G;
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
	void getData(); //Прототип на член-функцията getData
	void display(); //Прототип на член-функцията display
};

// Член-функцията getData на класа Registar
void Registar::getData(){
	Kniga::getData();
	Lice::getData();
	cout << "Регистрационен номер: "; cin.getline(RegNom, 16);
	cout << "Дата за връщане на книгата: \n"; DatVr.getData();
}

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

	cout << "\nВъведи текущата дата: \n"; currentDate.getData();

	cout << "\nВъведи рег. номер на книга за изтриване: "; cin.ignore(); cin.getline(regNomIztr, 7);
	for (int i = 0; i < br; ++i)
	{
		dateCompare = datcmp(currentDate, dk[i].DatVr);
		if (dateCompare > 0 && strcmp(dk[i].RegNom, regNomIztr) == 0){
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

	cout << "\nВъведи текущата дата: \n"; KontrDat.getData(); cout << endl;
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

	cout << "\nВъведи текущата дата: \n"; KontrDat.getData(); cout << endl;
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
	do {
		cout << "\nМЕНЮ НА ИЗПЪЛНЯВАНИТЕ ОПЕРАЦИИ:\n";
		cout << " 1 - за дoбавяне данни за дадени книги\n";
		cout << " 2 - за извеждане данните на всички раздад. книги.\n";
		cout << " 3 - за изтриване на върната книга;\n";
		cout << " 4 - за списък с данните на читат., невърнали книги;\n";
		cout << " 5 - за създаване масив с данните на невърнат.книги;\n";
		cout << "Посочете операция или 0 за край: "; cin >> KodOp;
		switch (KodOp) {
		case '0':break;
		case '1':
			DadKni[BrDadKn++].getData();
			break;
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

