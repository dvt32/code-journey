/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*

2.2. Да се състави програма за нуждите на хотел, която поддържа в масив следната информация за гостите на хотела:
- име - низ до 20 знака;
- ЕГН - низ от 10 знака;
- семейно положение (1-несемеен, 2-семеен);
- брой нощувки - цяло число;
- цена на ползваното легло - реално число;
- населено място - низ до 25 знака

Извършва следните операции, избирани от меню:
- записва в едномерен масив въведените данни;
- извежда на екрана всички въведени данни;
- извежда на екрана имената и заплатената сума от семейните гости, пребивавали повече от 5 дни;
- създава нов масив с данните на несемейните гости от посочено населено място. 

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <conio.h>
#include <stdlib.h>

class Hotel{
public:
	char name[21], EGN[11], location[26];
	int familyType, brNights;
	double bedPrice;

	void cinInfo();
	void coutInfo();
};

// Функция за въвеждане на данните
void Hotel::cinInfo(){
	cout << "\n---\n";
	cin.ignore();
	cout << "Име: "; cin.getline(name, 21);
	cout << "ЕГН: "; cin.getline(EGN, 11);
	cout << "Семейно положение (1 - несемеен, 2 - семеен): "; cin >> familyType;
	cout << "Брой нощувки: "; cin >> brNights;
	cout << "Цена на ползуваното легло: "; cin >> bedPrice; cin.ignore();
	cout << "Населено място: "; cin.getline(location, 26);
	cout << "---\n";
}

// Функция за извеждане на данните
void Hotel::coutInfo(){
	cout << "Име: " << name << endl;
	cout << "ЕГН: " << EGN << endl;
	if (familyType == 1) { cout << "Семейно положение: " << familyType << " (несемеен)" << endl; }
	if (familyType == 2) { cout << "Семейно положение: " << familyType << " (семеен)" << endl; }
	cout << "Брой нощувки: " << brNights << endl;
	cout << "Цена на ползуваното легло: " << bedPrice << " лв." << endl;
	cout << "Населено място: " << location << endl << endl;
}





void main(){
	system("chcp 1251");

	Hotel Group[30],
			Group2[30];	// масив за опция 4 от менюто

	int menuCode,
		i, j,
		br = 0, // брой гости в хотела
		br2 = 0; // брой гости в хотела, отговарящи на условието в опция 4 от менюто

	char locationSearch[26]; // търсено населено място (за опция 4 от менюто)

	do
	{
		cout << endl << "МЕНЮ: " << endl;
		cout << " - [1]: Добави данни" << endl;
		cout << " - [2]: Изведи всички данни" << endl;
		cout << " - [3]: Изведи имената и платената сума от сем. гости, стояли повече от 5 дни." << endl;
		cout << " - [4]: Създай масив с данните на несемейните гости от посочено населено място." << endl;

		cout << endl << "Въведи номер на операция (0 за край): "; cin >> menuCode;

		switch (menuCode){
		case 0: break;
		case 1:
			Group[br++].cinInfo(); break;
		case 2:
			cout << "\n---\n" << "Всички въведени данни: " << endl << endl;
			for (i = 0; i < br; ++i) { Group[i].coutInfo(); }
			cout << "---\n\n";
			break;
		case 3:
			cout << "\n---\n" << "Имена и заплатена сума от семейните гости, стояли повече от 5 дни: " << endl << endl;
			for (i = 0; i < br; ++i){
				if (Group[i].brNights > 5 && Group[i].familyType == 2){
					cout << "Име: " << Group[i].name << endl;
					cout << "Заплатена сума: " << (double)Group[i].brNights * Group[i].bedPrice << " лв."
						<< "(" << Group[i].brNights << " нощувки по " << Group[i].bedPrice << " лв.)"
						<< endl << endl;
				}
			}
			cout << "---\n\n";
			break;
		 case 4:
			 
			 cout << "\n---\n" 
				 << "Въведи населено място: "; cin.ignore(); cin.getline(locationSearch, 26); 
			 cout << endl << "Данните на несемейните гости от " << locationSearch << ": \n\n";
			 for (i = 0, j = 0; i < br; ++i)
			 {
				 if (strcmp(Group[i].location, locationSearch) == 0
					 && Group[i].familyType == 1)
				 {
					 br2++;
					 strcpy_s(Group2[j].name, Group[i].name);
					 strcpy_s(Group2[j].EGN, Group[i].EGN);
					 Group2[j].familyType = Group[i].familyType;
					 Group2[j].brNights = Group[i].brNights;
					 Group2[j].bedPrice = Group[i].bedPrice;
					 strcpy_s(Group2[j].location, Group[i].location);
					 Group2[j].coutInfo();
					 j++;
				 }
			 }
			 if (br2 == 0) { cout << "Няма намерени резултати. " << endl; }
			 cout << "---\n\n";
			 break;
		default: cout << "Невалиден номер на операция." << endl;
		}
	}

	while (menuCode != 0);


}

