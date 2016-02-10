/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*

1.3 Да се състави програма, която съхранява в масив следната информация за лекарствата в една аптека:
- наименование - низ до 20 знака;
- цена - реално число;
- налично количество - цяло число;
- дата, до която е годно за употреба

Извършва следните операции, избирани от меню:
- добавя към масива данните на ново лекарство;
- извежда всички въведени данни;
- извежда стойността на лекарствата, чийто срок на годност изтича на посочена дата;
- създава нов масив с данните на лекарствата с цена под 10 лв;
- създава нов масив с имената и наличните количества на лекарствата с цена над 15 лв

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <conio.h>
#include <stdlib.h>

class Apteka{
public:
	char name[21];
	double price;
	int quantityLeft, 
		expDate_year,
		expDate_month, 
		expDate_day;

	void cinInfo();
	void coutInfo();
};

// Функция за въвеждане на данните
void Apteka::cinInfo(){
	cout << "\n---\n";
	cin.ignore();
	cout << "Наименование: "; cin.getline(name, 21);
	cout << "Цена: "; cin >> price;
	cout << "Налично количество: "; cin >> quantityLeft;
	cout << "Срок на годност: " << endl;
	cout << " - месец: "; cin >> expDate_month;
	cout << " - ден: "; cin >> expDate_day;
	cout << " - година: "; cin >> expDate_year;
	cout << "---\n";
}

// Функция за извеждане на данните
void Apteka::coutInfo(){
	cout << "Наименование: " << name << endl;
	cout << "Цена: " << price << " лв." << endl;
	cout << "Налично количество: " << quantityLeft << " бр." << endl;
	cout << "Срок на годност до: ";
	if (expDate_month < 10) { cout << "0" << expDate_month << "."; }
	else { cout << expDate_month << "."; } 
	if (expDate_day < 10) {cout << "0" << expDate_day << "."; }
	else { cout << expDate_day << "."; }
	cout << expDate_year << " г." << endl;
}





void main(){
	system("chcp 1251");

	Apteka Group[30],
		   Group2[30],	// масив за опция 4 от менюто
		   Group3[30];	// масив за опция 5 от менюто
	int menuCode,
		i, j,
		expDateMonth,
		expDateDay,
		expDateYear,	// търсен срок на годност в опция 5 от менюто (месец/ден/година)
		br = 0,			// брой лекарства
		br2 = 0;		// брой лекарства, отговарящи на условието в опция 5

	double sum = 0;

	do
	{
		cout << endl << "МЕНЮ: " << endl;
		cout << " - [1]: Добави данни за лекарство" << endl;
		cout << " - [2]: Изведи данните за добавените лекарства" << endl;
		cout << " - [3]: Изведи стойността на лекарствата, чийто срок на годност изтича на посочена дата" << endl;
		cout << " - [4]: Създай масив с данните на лекарствата с цена под 10 лв." << endl;
		cout << " - [5]: Създай масив с имената/количествата на лекарствата с цена над 15 лв." << endl;

		cout << endl << "Въведи номер на операция (0 за край): "; cin >> menuCode;

		switch (menuCode){
		case 0: break;
		case 1:
			Group[br++].cinInfo(); break;
		case 2:
			cout << "\n---\n" << "Всички въведени данни: " << endl << endl;
			for (i = 0; i < br; ++i) { Group[i].coutInfo(); cout << "\n\n"; }
			cout << "---\n\n";
			break;
		case 3:
			cout << "\n---\n";
			 cout << "Въведи търсения срок на годност: " << endl;
			 cout << " - месец: "; cin >> expDateMonth;
			 cout << " - ден: "; cin >> expDateDay;
			 cout << " - година: "; cin >> expDateYear;
			 cout << endl;

			 for (i = 0; i < br; ++i){
				 if (Group[i].expDate_month == expDateMonth &&
					 Group[i].expDate_day == expDateDay &&
					 Group[i].expDate_year == expDateYear)
				 {
					 cout << "Наименование: " << Group[i].name << endl;
					 cout << "Цена: " << Group[i].price << " лв." << endl << endl;
					 br2++;
				 }
			 }
			 if (br2 == 0) { cout << "Няма намерени резултати." << endl; }
			 cout << "---\n\n";
			 break;
		 case 4:
			 cout << "\n---\n" << "Лекарства с цена под 10 лв: " << endl << endl;
			 for (i = 0, j = 0; i < br; ++i) {
				 if (Group[i].price < 10) {
					 strcpy_s(Group2[j].name, Group[i].name);
					 Group2[j].price = Group[i].price;
					 Group2[j].quantityLeft = Group[i].quantityLeft;
					 Group2[j].expDate_day = Group[i].expDate_day;
					 Group2[j].expDate_month = Group[i].expDate_month;
					 Group2[j].expDate_year = Group[i].expDate_year;
					 Group2[j].coutInfo();
					 cout << "\n";
					 j++;
				 }
			 }
			 cout << "---\n\n";
			 break;
		 case 5:
			 cout << "\n---\n" << "Лекарства с цена над 15 лв: " << endl << endl;
			 for (i = 0, j = 0; i < br; ++i) {
				 if (Group[i].price > 15) {
					 strcpy_s(Group3[j].name, Group[i].name);
					 Group3[j].quantityLeft = Group[i].quantityLeft;
					 cout << "Наименование: " << Group3[j].name << endl;
					 cout << "Налично количество: " << Group3[j].quantityLeft << " бр." << endl << endl;
					 cout << "\n";
					 j++;
				 }
			 }
			 cout << "---\n\n"; 
			 break;
		default: cout << "Невалиден номер на операция." << endl;
		}
	}

	while (menuCode != 0);


}


