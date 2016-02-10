/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

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

В упражнение 7 са създадени базов клас Proizvoditel и производен клас Stoka.
Новата задача е да добавите към тези два класа по два конструктора.
- Единият да инициализира всички членове на съответния клас,
- а другият – само част от тях.

*/


#include "stdafx.h" 
using namespace std;
#include <iostream> 
#include <conio.h> 
#include <stdlib.h> 

// Клас Производител 
class Proizvoditel{
protected:
	char FirmNom[9], Naimenovanie[31], Adres[21], Tel[11];
public:
	Proizvoditel(){};								// Подразбиращ се конструктор
	Proizvoditel(char*, char*, char*, char*);		// Конструктор 1, инициализиращ всички член-данни
	Proizvoditel(char[], char[]);					// Конструктор 2, инициализиращ 2 член-данни

	// Забележка: вторият конструктор не се използва в програмата

	void display();

	friend class Stoka;								// Нужно, за да може SzdMasPro да има достъп до член-данните на Proizvoditel
};

// Конструктор на класа Proizvoditel, инициализиращ всички член-данни
Proizvoditel::Proizvoditel(char *fNum, char *name, char *address, char *phoneNumber){
	strcpy_s(FirmNom, fNum);
	strcpy_s(Naimenovanie, name);
	strcpy_s(Adres, address);
	strcpy_s(Tel, phoneNumber);
}

// Конструктор на класа Proizvoditel, инициализиращ 2 член-данни (фирмен номер и наименоваие)
Proizvoditel::Proizvoditel(char fNum[], char name[]){
	strcpy_s(FirmNom, fNum);
	strcpy_s(Naimenovanie, name);
}

// Член-функцията display на класа Proizvoditel  
void Proizvoditel::display(){
	cout << "Фирма: " << endl;
	cout << "- Фирмен номер: " << FirmNom << endl;
	cout << "- Наименование на фирмата: " << Naimenovanie << endl;
	cout << "- Адрес на фирмата: " << Adres << endl;
	cout << "- Телефон за връзка: " << Tel << endl << endl;
};

// Клас Stoka 
class Stoka : public Proizvoditel{
	char StokNom[7], StokaName[31];
	double price;
	int quantityLeft;
public:

	Stoka(){};								// Подразбиращ се конструктор

	Stoka									// Конструктор 1, инициализиращ всички член-данни
		(char*, char*, char*, char*,		// Член-данни на Proizvoditel (задължително е да има аргументи за тях)	
		char*, char*, double, int);			// Член-данни на Stoka		

	Stoka									// Конструктор 2, инициализиращ някои член-данни	
		(char[], char[],					// Член-данни на Proizvoditel (ще се използва втория конструктор на Proizvoditel)									
		char[], double, int);				// Член-данни на Stoka		

	// Забележка: вторият конструктор не се използва в програмата

	void display();

	// Функциите IztrStoka, SpisProStok, SzdMasPro стават член-функции на Stoka, за да имат достъп до член-данните на класа
	void IztrStoka(int&, Stoka[]);			
	void SpisProStok(Stoka[], int);
	void SzdMasPro(Stoka[], int, Proizvoditel[], int&);
};

// Конструктор на класа Stoka, инициализиращ всички член-данни
Stoka::Stoka(char *fNum, char *name, char *address, char *phoneNumber, char *sNum, char *sName, double pr, int qLeft)
: Proizvoditel(fNum, name, address, phoneNumber)
{
	strcpy_s(StokNom, sNum);
	strcpy_s(StokaName, sName);
	price = pr;
	quantityLeft = qLeft;
}

// Конструктор на класа Stoka, инициализиращ някои член-данни (име на стока, цена, налично количество)
Stoka::Stoka(char fNum[], char name[], char sName[], double pr, int qLeft)
: Proizvoditel(fNum, name)
{
	strcpy_s(StokaName, sName);
	price = pr;
	quantityLeft = qLeft;
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
void Stoka::IztrStoka(int &br, Stoka stoki[]){
	char stokNomIztr[7];//Стоков номер на стоката за изтриване 
	cout << "\nСтоков номер на стоката за изтриване: "; cin >> stokNomIztr;
	for (int i = 0; i<br; i++)
	if (stoki[i].quantityLeft == 0 && strcmp(stoki[i].StokNom, stokNomIztr) == 0){
		stoki[i] = stoki[br - 1];
		br--;
		return;
	}
	cout << "Грешен регистрационен номер!\n";
}

// Функция, извеждаща данните на производителите на посочена стока 
void Stoka::SpisProStok(Stoka stoki[], int br){
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
void Stoka::SzdMasPro(Stoka stoki[], int brSt, Proizvoditel proiz[], int &brPro){
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
	char KodOp; int i, BrSt = 0;
	Stoka Stoki[10],
		fCall; // обект за извикване на член-функциите IztrStoka, SpisProStok, SzdMasPro
	Proizvoditel Proiz[10]; int BrPro;

	do {
		cout << "\nМЕНЮ НА ИЗПЪЛНЯВАНИТЕ ОПЕРАЦИИ:\n";
		cout << "  [1] - за дoбавяне данни за нова стока\n";
		cout << "  [2] - за извеждане данните на всички стоки\n";
		cout << "  [3] - за изтриване на изчерпана стока;\n";
		cout << "  [4] - извежда списък с данните на производиелите на посочена стока;\n";
		cout << "  [5] - създава масив с данните на производителите на стоки с цена под 10 лв.;\n";
		cout << "Посочете операция или 0 за край: "; cin >> KodOp; cin.ignore();
		switch (KodOp) {
		case '0': break;
		case '1':
		{
			// Деклариране на променливи, временно съдържащи стойности за член-данните на Proizvoditel 
			char fNumber[9], fName[31], fAddress[21], fTel[11];

			// Деклариране на променливи, временно съдържащи стойности за член-данните на Stoka
			char sNumber[7], sName[31]; double sPrice; int sQuantityLeft;

			// Въвеждане на данните за член-данните на Stoka/Proizvoditel и запазване във временните променливи
			cout << "\nСтоков номер: "; cin.getline(sNumber, 7);
			cout << "Наименование на стоката: "; cin.getline(sName, 31);
			cout << "Цена: "; cin >> sPrice;
			cout << "Налично количество: "; cin >> sQuantityLeft; cin.ignore();
			cout << "Фирма: " << endl;
			cout << "- Фирмен номер: "; cin.getline(fNumber, 9);
			cout << "- Наименование на фирмата: "; cin.getline(fName, 31);
			cout << "- Адрес на фирмата: "; cin.getline(fAddress, 21);
			cout << "- Телефон за връзка: "; cin.getline(fTel, 11);

			// Използване на конструктора за инициализиране на член-данните на Stoka/Proizvoditel със с/сти от вр.променливи
			Stoka foobar(fNumber, fName, fAddress, fTel, sNumber, sName, sPrice, sQuantityLeft);
			Stoki[BrSt] = foobar;

			BrSt++;
			break;
		}
		case '2':cout << "\nСписък на всички стоки:\n";
			for (i = 0; i<BrSt; i++) Stoki[i].display(); break;
		case '3': fCall.IztrStoka(BrSt, Stoki);
			break;
		case '4': fCall.SpisProStok(Stoki, BrSt);
			break;
		case '5': fCall.SzdMasPro(Stoki, BrSt, Proiz, BrPro);
			cout << "\nДанни на производителите на стоки с цена под 10 лв:\n\n";
			for (i = 0; i<BrPro; i++) Proiz[i].display();
			break;
		default: cout << "Грешен код на операция.\n";
		}
	} while (KodOp != '0');
}
