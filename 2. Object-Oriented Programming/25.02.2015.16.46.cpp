/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*

5.5. Да се състави програма за нуждите на производствена организация, която съхранява в масив следните данни за работниците:
- име - низ до 25 знака;
- ЕГН - низ от 10 знака;;
- размер на дневното заплащане - реално число;
- брой на отработени дни през месеца - цяло число

Извършва следните операции, избирани от меню:
- добавя към масива данните на нов работник;
- извежда всички въведени данни;
- извежда имената и възрастта на всички мъже;
- създава нов масив с имената и месечното заплащане на мъжете.

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <conio.h>
#include <stdlib.h>

class Organization{
public:
	char name[26], EGN[11], gender[5];
	double dailyPay, monthlyPayment;
	int brWorkDays,
		monthOfBirth,
		dayOfBirth,
		yearOfBirth,
		age;

	void cinInfo();
	void coutInfo();
};

// Функция за въвеждане на данните
void Organization::cinInfo(){
	cout << "\n---\n";
	cin.ignore();
	cout << "Име: "; cin.getline(name, 21);
	cout << "ЕГН: "; cin.getline(EGN, 11);
	cout << "Дневно заплащане: "; cin >> dailyPay;
	cout << "Брой отработени дни: "; cin >> brWorkDays;
	cout << "---\n";
}

// Функция за извеждане на данните
void Organization::coutInfo(){
	cout << "Име: " << name << endl;
	cout << "ЕГН: " << EGN << endl;
	cout << "Дневно заплащане: " << dailyPay << " лв." << endl;
	cout << "Брой отработени дни: " << brWorkDays << " дни" << endl << endl;
}

// Функция за определяне на нужните данни за опция 3 и 4 от менюто
void findInfo(Organization Group[], int br){
	int gender_int;
	char yearOfBirth_s[3], monthOfBirth_s[3], dayOfBirth_s[3], gender_s[2];

	for (int i = 0; i < br; ++i){
		// Отделяне на годината на раждане.
		strncpy_s(yearOfBirth_s, Group[i].EGN, 2);
		Group[i].yearOfBirth = atoi(yearOfBirth_s) + 1900;
		// Отделяне на месеца на раждане
		strncpy_s(monthOfBirth_s, Group[i].EGN + 2, 2);
		Group[i].monthOfBirth = atoi(monthOfBirth_s);
		if (Group[i].monthOfBirth > 12) { Group[i].monthOfBirth -= 40; Group[i].yearOfBirth += 100; }
		// Отделяне на деня на раждане
		strncpy_s(dayOfBirth_s, Group[i].EGN + 4, 2);
		Group[i].dayOfBirth = atoi(dayOfBirth_s);
		// Определяне на пола
		strncpy_s(gender_s, Group[i].EGN + 8, 1);
		gender_int = atoi(gender_s);
		if (gender_int % 2 == 1){ strcpy_s(Group[i].gender, "жена"); }
		if (gender_int % 2 == 0){ strcpy_s(Group[i].gender, "мъж"); }
		// Определяне на месечното плащане (заработката)
		Group[i].monthlyPayment = 31 * Group[i].dailyPay;
	}

}

void main(){
	system("chcp 1251");

	Organization Group[30],
		Group2[30];					// масив за опция 4 от менюто

	int menuCode,
		i, j,
		yearNow, monthNow, dayNow, // текуща година, месец, ден (нужни за опция 3 от менюто)
		br = 0;

	do
	{
		cout << endl << "МЕНЮ: " << endl;
		cout << " - [1]: Добави данни за работник" << endl;
		cout << " - [2]: Изведи всички данни за работниците" << endl;
		cout << " - [3]: Изведи имената и възрастта на всички мъже" << endl;
		cout << " - [4]: Създай масив с имената и месечното заплащане на мъжете" << endl;

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

			cout << "\n---\n";

			cout << "Въведи текуща дата: " << endl;
			cout << "- ден: "; cin >> dayNow;
			cout << "- месец: "; cin >> monthNow;
			cout << "- година: "; cin >> yearNow; cout << endl; cin.ignore();

			cout << "Име и възраст на всички мъже: " << endl << endl;
			findInfo(Group, br);
			for (i = 0; i < br; ++i){
				if (strcmp(Group[i].gender, "мъж") == 0)
				{
					cout << "Име: " << Group[i].name << endl;
					Group[i].age = yearNow - Group[i].yearOfBirth;
					if (monthNow < Group[i].monthOfBirth ||
						monthNow == Group[i].monthOfBirth &&
						dayNow < Group[i].dayOfBirth){
						Group[i].age--;
					}
					cout << "Възраст: " << Group[i].age << " г." << endl << endl;
				}
			}
			cout << "---\n\n";
			break;
		case 4:
			findInfo(Group, br);
			cout << "\n---\n" << "Имена и месечно заплащане на всички мъже: " << endl << endl;
			for (i = 0, j = 0; i < br; ++i){
				if (strcmp(Group[i].gender, "мъж") == 0)
				{
					strcpy_s(Group2[j].name, Group[i].name);
					Group2[j].monthlyPayment = Group[i].monthlyPayment;

					cout << "Име: " << Group2[j].name << endl;
					cout << "Месечно заплащане: " << Group2[j].monthlyPayment << " лв.\n\n";

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

