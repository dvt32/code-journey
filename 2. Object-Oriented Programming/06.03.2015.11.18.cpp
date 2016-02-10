/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*

1. Да се състави програма, която съхранява в масив следните данни за книгите в една библиотека:
- инвентарен номер - низ до 6 знака;
- автор - низ от 20 знака;
- заглавие - низ до 30 знака;
- обем на книгата (брой страници) - цяло число;
- цена - реално число;

И извършва следните операции:
- добавя към масива данни за поредна книга;
- извежда на екрана данните за всички книги;
- изтрива данните за книга със зададен инв.номер;
- намира и извежда сумата от цените на всички книги;
- извежда данните на всички книги от зададен автор;
- създава нов масив с всички данни за книгите с цена до 15 лв.
- създава нов масив, съдържащ заглавията и цените на книгите до 150 стр.

За да създадете тази програма, трябва да изпълните следното:
- да създадете клас "Книга" с член-данни (инвентарен номер, автор, заглавие, обем и цена) и член функции за въвеждане и извеждане данните за една една книга;
- да създадете главна функция, която включва необходимите масиви и менюто на изпълняваните операции;
- да създадете функциите, които реализират изпълняваните операции;

По-долу тази програма е частично направена. За да я завършите, направите следното:
- внимателно проучете направеното по тази задача, за да можете сами да го направите при следваща подобна задача;
- напишете функциите, които реализират опциите 3,4,5,6 и 7 от предложеното меню.

Последната от изпълняваните операции налага да се създаде нов клас, защото масивът, който тя създава не е от класа Kniga.

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <conio.h>
#include <stdlib.h>
//Клас Kniga
class Kniga{
public:
	char InvNom[7], Avtor[21], Zaglavie[76];
	int Obem;
	float Cena;
	void getData();
	void display();
};
//Член-функцията getData на класа Kniga
void Kniga::getData(){
	cin.ignore();
	cout << "Инвентарен номер: "; cin.getline(InvNom, 20);
	cout << "Автор: "; cin.getline(Avtor, 20);
	cout << "Заглавие: "; cin.getline(Zaglavie, 75);
	cout << "Обем: "; cin >> Obem;
	cout << "Цена: "; cin >> Cena;
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
float SumaCeni(Kniga masKnig[], int n){
	float sum = 0;
	for (int i = 0; i < n; i++){
		sum += masKnig[i].Cena;
	}
	return sum;
}

//Извеждане данните на книгите от зададен автор
void KnigiZadAvtot(Kniga masKnig[], int n, char zadAvtor[]){
	for (int i = 0; i < n; i++){
		if (strcmp(zadAvtor, masKnig[i].Avtor) == 0){
			cout << "Заглавие: " << masKnig[i].Zaglavie << endl;
			cout << "Инвентарен номер: " << masKnig[i].InvNom << endl;
			cout << "Обем: " << masKnig[i].Obem << endl;
			cout << "Цена: " << masKnig[i].Cena << endl << endl;
		}
	}
}

//Функция за изтриване данните на книга със зададен инвентарен номер
void IztriKni(Kniga masKnig[], int &n){
	cin.ignore();
	char ZadInvNom[7];
	cout << "Задайте инвентарния номер: "; cin.getline(ZadInvNom, 6);
	for (int i = 0; i < n; i++)
	{
		if (strcmp(masKnig[i].InvNom, ZadInvNom) == 0)
		{
			masKnig[i] = masKnig[n - 1];
			n--;
		}
	}
	cout << "Операцията приключи.";
}


//Функция за създаване на масив с всички данни за книгите с цена до 15 лв.
void SzdMas15(Kniga masKnig[], int brKn, Kniga masKnig15[], int &brKn15){
	brKn15 = 0;
	for (int i = 0, j = 0; i < brKn; i++){
		if (masKnig[i].Cena <= 15)
		{
			brKn15++;
			masKnig15[j] = masKnig[i];
			j++;
		}
	}
}


// Създаване на нов клас, нужен за създаване на масив, съдържащ заглавията и цените на книгие под 150 стр.
class Kniga1{
public:
	char zaglavie[31];
	float cena;
	void display(){
		cout << zaglavie << " " << cena << endl;
	}
};


//Функция за създаване на на масив, съдържащ заглавията и цените на книгие под 150 стр.
void SzdNovMas(Kniga masKnig[], int brKn, Kniga1 masKnig150[], int &brKn150){
	brKn150 = 0;
	for (int i = 0, j = 0; i < brKn; i++){
		if (masKnig[i].Obem < 150)
		{
			brKn150++;
			strcpy_s(masKnig150[j].zaglavie, masKnig[i].Zaglavie);
			masKnig150[j].cena = masKnig[i].Cena;
			j++;
		}
	}
}


//Главна функция main
void main(){
	system("chcp 1251");
	char KodOp;
	int i, BrKn = 0, //-брой книги в библиотеката
		BrKn15, //-брой книги в библиотеката с цена до 15 лв.
		BrKn150; //-брой книги в библиотеката с обем до 150 стр.
	Kniga MasKnigi[10], //-масив с данните на всички книги
		MasKnig15[10]; //-масив с данните на книгите с цена до 15 лв.
	Kniga1 MasKnig150[10]; //-масив с данните на книгите с обем до 150 стр.
	char ZadAvtor[21]; //-името на зададения автор
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
		case '1':MasKnigi[BrKn++].getData(); break;
		case '2':cout << "\nСписък на всички кнги:\n";
			for (i = 0; i<BrKn; i++) MasKnigi[i].display();
			break;
		case '3':cout << "Сумата от цените на всички книги е "
			<< SumaCeni(MasKnigi, BrKn) << endl;
			break;
		case '4':cin.ignore();
			cout << "Задайте автора: "; cin.getline(ZadAvtor, 20);
			cout << "\n\tKниги от " << ZadAvtor << ":\n";
			KnigiZadAvtot(MasKnigi, BrKn, ZadAvtor); break;
		case '5': IztriKni(MasKnigi, BrKn); break;
		case '6':SzdMas15(MasKnigi, BrKn, MasKnig15, BrKn15);
			for (i = 0; i<BrKn15; i++) MasKnig15[i].display();
			break;
		case '7':SzdNovMas(MasKnigi, BrKn, MasKnig150, BrKn150);
			for (i = 0; i<BrKn150; i++) MasKnig150[i].display();
			break;
		default: cout << "Грешен код на операция.\n";
		}
	} while (KodOp != '0');
}
