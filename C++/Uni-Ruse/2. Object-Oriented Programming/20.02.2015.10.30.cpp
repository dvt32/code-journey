/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*

1.4 Да се състави програма, която съхранява в масив следната информация за лекарствата в една аптека:
- наименование - низ до 20 знака;
- цена - реално число;
- налично количество - цяло число;
- дата, до която е годно за употреба

Извършва следните операции, избирани от меню:
- добавя към масива данните на ново лекарство;
- извежда всички въведени данни;
- извежда загубата от лекарствата с изтекъл срок към зададена дата;
- създава нов масив с данните на лекарствата с изтичаща годност днес;
- създава нов масив с имената и цените на всички лекарства.

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <conio.h>
#include <stdlib.h>
#include <ctime> // нужна библиотека за извеждане на днешната дата

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
		expDateYear,	// търсен срок на годност (месец/ден/година)
		br = 0,			// брой лекарства
		br2 = 0;		// брой лекарства, отговарящи на условието в опция 5

	double sum = 0,		// сума от цените на всички лекарства
		    sum2 = 0;	// сума, включваща цените на лекарствата, чиито срок на годност изтича на зададена дата (т.е. загубата)

	// Определяне на днешната дата
	time_t t = time(0);   // вземи сегашното време
	struct tm * now = localtime( & t );
	int monthNow = (now->tm_mon + 1),
		dayNow = now->tm_mday,
		yearNow = (now->tm_year + 1900);

	do
	{
		cout << endl << "МЕНЮ: " << endl;
		cout << " - [1]: Добави данни за лекарство" << endl;
		cout << " - [2]: Изведи данните за добавените лекарства" << endl;
		cout << " - [3]: Изведи загубата от лекарствата с изтекъл срок към зададена дата" << endl;
		cout << " - [4]: Създай масив с данните на лекарствата с изтичаща годност днес" << endl;
		cout << " - [5]: Създай масив с имената и цените на всички лекарства." << endl;

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

			 // Намиране на общата сума на лекарствата.
			 for (i = 0; i < br; ++i) { sum += Group[i].price; }
			 cout << "Обща сума на всички лекарства: " << sum << " лв." << endl << endl;
			 sum = 0;

			 // Извеждане на данните на лекарствата с търсения срок на годност
			 for (i = 0; i < br; ++i){
				 if (Group[i].expDate_month == expDateMonth &&
					 Group[i].expDate_day == expDateDay &&
					 Group[i].expDate_year == expDateYear)
				 {
					 cout << "Наименование: " << Group[i].name << endl;
					 cout << "Срок на годност до: ";
					 if (Group[i].expDate_month < 10) { cout << "0" << Group[i].expDate_month << "."; }
					 else { cout << Group[i].expDate_month << "."; } 
					 if (Group[i].expDate_day < 10) {cout << "0" << Group[i].expDate_day << "."; }
					 else { cout << Group[i].expDate_day << "."; }
					 cout << Group[i].expDate_year << " г." << endl;
					 cout << "Цена: " << Group[i].price << " лв." << endl << endl;
					 br2++;

					 // Калкулиране на загубата
					 if (yearNow >= expDateYear){
						 if (monthNow >= expDateMonth)
							 if (dayNow >= expDateDay)
						{sum2 += Group[i].price;} 
					}
				 }
			 }
			 if (br2 == 0) { cout << "Няма намерени резултати." << endl; }

			 

			 // Извеждане на загубата
			 cout << "Загубата е равна на: " << sum2 << " лв." << endl << endl;
			 sum2 = 0;
			 cout << "---\n\n";  
			 break;
		 case 4:
			 cout << "\n---\n" << "Лекарства с изтичащ срок на годност днес: " << endl << endl;
			 for (i = 0, j = 0; i < br; ++i) {
				 if (Group[i].expDate_month == monthNow &&
					 Group[i].expDate_day == dayNow &&
					 Group[i].expDate_year == yearNow) 
				 {
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
			 cout << "\n---\n" << "Имена и цени на всички лекарства: " << endl << endl;
			 for (i = 0, j = 0; i < br; ++i) 
			 {
					 strcpy_s(Group3[j].name, Group[i].name);
					 Group3[j].price = Group[i].price;
					 cout << "Наименование: " << Group3[j].name << endl;
					 cout << "Цена: " << Group3[j].price << " лв." << endl << endl;
					 cout << "\n";
					 j++;
			 }
			 cout << "---\n\n"; 
			 break;
		default: cout << "Невалиден номер на операция." << endl;
		}
	}

	while (menuCode != 0);


}


