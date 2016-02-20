/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*

3.2. Да се състави програма за нуждите на туристическа агенция, която със следните съхранявани в масив данни за своите клиенти-туристи:
- име - низ до 20 знака;
- ЕГН - низ от 10 знака;
- телефон - низ от 10 знака;
- месечен доход- реално число;
- желана страна за посещение - низ до 25 знака

Извършва следните операции, избирани от меню:
- записва в едномерен масив въведените данни ;
- извежда на екрана всички въведени данни;
- извежда на екрана имената и датите на раждане на жените, родени през посочена година;
- създава нов масив с данните на клиентите с доход над 1000 лева, кандидати за посочена страна.

*/

#include "stdafx.h"
using namespace std;
#include <iostream>
#include <conio.h>
#include <stdlib.h>

class Tourist{
public:
	char name[21], EGN[11], phone[11], country[26], gender[5];
	double monthlyIncome;
	int monthOfBirth, dayOfBirth, yearOfBirth;

	void cinInfo();
	void coutInfo();
};

// Функция за въвеждане на данните
void Tourist::cinInfo(){
	cout << "\n---\n";
	cin.ignore();
	cout << "Име: "; cin.getline(name, 21);
	cout << "ЕГН: "; cin.getline(EGN, 11);
	cout << "Телефон: "; cin.getline(phone, 11);
	cout << "Месечен доход: "; cin >> monthlyIncome; cin.ignore();
	cout << "Желана страна за посещение: "; cin.getline(country, 26);
	cout << "---\n";
}

// Функция за извеждане на данните
void Tourist::coutInfo(){
	cout << "Име: " << name << endl;
	cout << "ЕГН: " << EGN << endl;
	cout << "Телефон: " << phone << endl;
	cout << "Месечен доход: " << monthlyIncome << " лв." << endl;
	cout << "Желана страна за посещение: " << country << endl << endl;
}

// Функция за определяне на нужните данни за опция 3 от менюто
void findInfo(Tourist Group[], int br){
	int gender_int;
	char yearOfBirth_s[3], monthOfBirth_s[3], dayOfBirth_s[3], gender_s[2];

	for (int i = 0; i < br; ++i){
		// Отделяне на годината на раждане.
		strncpy_s(yearOfBirth_s, Group[i].EGN, 2);
		Group[i].yearOfBirth = atoi(yearOfBirth_s) + 1900;
		// Отделяне на месеца на раждане
		strncpy_s(monthOfBirth_s, Group[i].EGN+2, 2);
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
	}
	
}

void main(){
	system("chcp 1251");

	Tourist Group[30],
			Group2[30];		// масив за опция 4 от менюто

	int menuCode,
		i, j,
		br = 0,
		br2 = 0,			// брой жени родени в търсената година в опция 3 от менюто
		br3 = 0;			// брой клиенти с доход над 1000 лв., кандидати за дадена държава

	int yearSearch;			// търсена година в опция 3 от менюто
	char countrySearch[26]; // търсена страна в опция 4 от менюто

	do
	{
		cout << endl << "МЕНЮ: " << endl;
		cout << " - [1]: Добави данни" << endl;
		cout << " - [2]: Изведи всички данни" << endl;
		cout << " - [3]: Изведи име и датa на раждане на жените, родени през посочена година." << endl;
		cout << " - [4]: Създай масив с данните на клиентите с доход над 1000 лева, кандидати за посочена страна." << endl;

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
			cout << "\n---\n" << "Въведи година за търсене: "; cin >> yearSearch; cout << endl;
			findInfo(Group, br);
			for (i = 0; i < br; ++i){
				if (Group[i].yearOfBirth == yearSearch && strcmp(Group[i].gender, "жена") == 0){
					cout << "Име: " << Group[i].name << endl;
					cout << "Дата на раждане: "
						<< Group[i].monthOfBirth << "."
						<< Group[i].dayOfBirth << "."
						<< Group[i].yearOfBirth << " г." << endl << endl;
					br2++;
				}
			}	
			if (br2 == 0) { cout << "Няма намерени резултати." << endl; }
			cout << "---\n\n";
			break;
		 case 4:
			 cout << "\n---\n" 
				 << "Въведи държава: "; cin.ignore(); cin.getline(countrySearch, 26); cout << endl;
			 cout << endl << "Клиентите с доход над 1000 лева, кандидати за " << countrySearch << ": \n\n";	
			 for (i = 0, j = 0; i < br; ++i){
				 if (Group[i].monthlyIncome > 1000 && strcmp(Group[i].country, countrySearch) == 0){
					 strcpy_s(Group2[j].name, Group[i].name);
					 strcpy_s(Group2[j].EGN, Group[i].EGN);
					 strcpy_s(Group2[j].phone, Group[i].phone);
					 Group2[j].monthlyIncome = Group[i].monthlyIncome;
					 strcpy_s(Group2[j].country, Group[i].country);
					 Group2[j].coutInfo();
					 br3++;
				 }
			 }
			 if (br3 == 0) { cout << "Няма намерени резултати. " << endl; }
			 cout << "---\n\n";
			 break;
		default: cout << "Невалиден номер на операция." << endl;
		}
	}

	while (menuCode != 0);


}

