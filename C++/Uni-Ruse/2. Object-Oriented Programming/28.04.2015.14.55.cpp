/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*

Задача 1.

Да се състави програма, която съхранява във файл следните данни за книгите в една библиотека:
-инвентарен номер - низ до 6 знака;
-автор - низ от 20 знака;
-заглавие - низ до 30 знака;
-обем на книгата (брой страници) - цяло число;
-цена - реално число;

И извършва следните операции, избирани от меню :
-създава празен двоичен файл;
-добавя към файла данни за книга;
-извежда на екрана и в текст.файл данните за всички книги;
-изтрива данните за книга със зададен инвентарен номер;
-намира сумата от цените на книгите, невърнати в срок;
-извежда данните на всички книги от зададен автор на екрана;
-създава двоичен файл с данните за книги над 200 страници;
-създава двоичен файл, съдържащ заглавията и цените на книгите над 10 лв.

Всички член данни да са публични.

*/

#include "stdafx.h"
using namespace std;
#include<iostream> //Заради работата с потоци.
#include<fstream> //Заради работата с потоци.
#include<stdio.h> //Заради функциите unlink и rename.
#include<stdlib.h> //Заради функцията atoi.
#include<conio.h> //Клас DMG

class DMG{
public:
	int D, M, G; //Член-данни на класа DMG
	void getData(); //Прототип на член-функцията readDat
	void display(ostream&);//Прототип на член-функцията writeDat
};

// Дефиниция на член-функцията readDat от класа DMG
void DMG::getData(){
	cout << "- ден: "; cin >> D;
	cout << "- месец: "; cin >> M;
	cout << "- година: "; cin >> G;
}
// Дефиниция на член-функцията writeDat от класа DMG
void DMG::display(ostream &p = cout){
	p << D << '.' << M << '.' << G << endl;
}

//Функция за сравняване на дати
int datcmp(DMG D1, DMG D2)
{
	if (D1.G != D2.G) return D1.G - D2.G;
	if (D1.M != D2.M) return D1.M - D2.M;
	return D1.D - D2.D;
}

//Клас Kniga
class Kniga{
public:
	char InvNom[7], Avtor[21], Zaglavie[51];
	int Obem;
	float Cena;
	DMG DataVr;
	void getData(); //Прототип на член-функцията getData
	void display(ostream&); //Прототип на член-функцията display
};

//Член-функцията getData на класа Kniga
void Kniga::getData(){
	cin.ignore();
	cout << "Инвентарен номер: "; cin.getline(InvNom, 20);
	cout << "Автор: "; cin.getline(Avtor, 20);
	cout << "Заглавие: "; cin.getline(Zaglavie, 50);
	cout << "Обем: "; cin >> Obem;
	cout << "Цена: "; cin >> Cena;
	cout << "Дата на връщане:\n"; DataVr.getData();
}
//Член-функцията display на класа Kniga
void Kniga::display(ostream &p = cout){
	p << "\nИнвентарен номер: " << InvNom << endl;
	p << "Автор: " << Avtor << endl;
	p << "Заглавие: " << Zaglavie << endl;
	p << "Обем: " << Obem << endl;
	p << "Цена: " << Cena << endl;
	p << "Дата на връщане: "; DataVr.display(p);
}

Kniga A; ofstream fout; ifstream fin; char GlDvFl[31];

//Функция за създаване на празен файл
void Prazen(){
	fout.open(GlDvFl, ios::out | ios::binary); fout.close();
}

//Добавяне на книги към файла
void Dobaviane(){
	fout.open(GlDvFl, ios::app | ios::binary);
	A.getData();
	fout.write((char*)&A, sizeof(A));
	fout.close();
}

//Функция за извеждане данните на всички регистрирани книги
template <class T>
void Fl_EkranTxtFl(char GlDvFl[], T a, ostream &p = cout){

	ostream *o = &p;

	char imeTxtFl[21];
	fin.open(GlDvFl, ios::in | ios::binary);
	if (o != &cout){
		cout << "Име на текстовия файл: "; cin >> imeTxtFl;
		fout.open(imeTxtFl, ios::out);
	}
	while (fin.read((char*)&a, sizeof(a))) a.display(p);
	fin.close(); if (o != &cout) fout.close();
}

//Функция за изтриване данните за книга със зададен инв. номер
void Iztrivane(){
	char InvNomIztr[11];//Инв. номер на книгата за изтриване

	cout << "Въведи инвентарен номер: "; cin >> InvNomIztr;

	fin.open(GlDvFl, ios::in | ios::binary);
	fout.open("tempfile", ios::out | ios::binary);
	while (fin.read((char*)&A, sizeof(A)))
	{
		if (strcmp(A.InvNom, InvNomIztr) != 0) { fout.write((char *)&A, sizeof(A)); }
		else cout << "Книгата е изтрита успешно." << endl;
	}
	fin.close(); fout.close();
	_unlink(GlDvFl); rename("tempfile", GlDvFl);

}

//Функция за намиране сумата от цените на книгите, невърнати в срок
float SumaCeniSrok(){
	DMG KontrolData;

	float sum = 0;

	cout << "Въведи днешна дата: " << endl;
	cout << "- ден: "; cin >> KontrolData.D;
	cout << "- месец: "; cin >> KontrolData.M;
	cout << "- година: "; cin >> KontrolData.G; cout << endl;

	fin.open(GlDvFl, ios::in | ios::binary);
	while (fin.read((char*)&A, sizeof(A)))
	{
		int result = datcmp(A.DataVr, KontrolData);
		if (result < 0) sum += A.Cena;
	}
	fin.close();

	return sum;
}

//Функция за извеждане на екрана данните на всички книги от зададен автор
void KnigiAvtor(Kniga masKnig[], int &brKn){
	char avtor[21]; //Зададен автор

	brKn = 0;
	cin.ignore();

	cout << "Въведи автор: "; cin.getline(avtor, 21);

	fin.open(GlDvFl, ios::in | ios::binary);
	while (fin.read((char*)&A, sizeof(A)))
	{
		if (strcmp(A.Avtor, avtor) == 0)
		{
			masKnig[brKn++] = A;
		}
	}
	fin.close();

}
//Функция за създаване двоичен файл с данните за книги над 200 страници
void DvFl_nad200(char novDvFl[]){

	fin.open(GlDvFl, ios::in | ios::binary);
	fout.open(novDvFl, ios::app | ios::binary);
	while (fin.read((char*)&A, sizeof(A)))
	{
		if (A.Obem > 200) { fout.write((char*) &A, sizeof(A)); }
	}
	fout.close();
	fin.close();

}

//Нов клас
class clasZagCen{
public:
	char zaglavie[51];
	float cena;
	void display(ostream &p = cout){ p << zaglavie << ' ' << cena << endl; }
};

clasZagCen B;
//Ф-ия за създ.двоичен файл, съдържащ заглав. и цените на книгите с цена над 10лв.
void DvFlZagCen(char novDvFl1[]){

	fin.open(GlDvFl, ios::in | ios::binary);
	fout.open(novDvFl1, ios::app | ios::binary);
	while (fin.read((char*)&A, sizeof(A)))
	{
		if (A.Cena > 10)
		{
			strcpy_s(B.zaglavie, A.Zaglavie);
			B.cena = A.Cena;
			fout.write((char*)&B, sizeof(B));
		}
	}
	fout.close();
	fin.close();

}


//Главна функция main
void main(){
	system("chcp 1251");
	char KodOp, ImeTxtFl[21], NovDvFl1[21], NovDvFl2[21];
	Kniga MasKnig[25]; int i, BrKn;
	cout << endl << "Име на главния двоичен файл: "; cin >> GlDvFl; cout << endl;
	do {
		cout << endl << " МЕНЮ НА ИЗПЪЛНЯВАНИТЕ ОПЕРАЦИИ:\n";
		cout << "\t1 - създаване на нов файл;\n";
		cout << "\t2 - добавяне данни за книги;\n";
		cout << "\t3 - извеждане данните на всички книги на екрана;\n";
		cout << "\t4 - извеждане данните на всички книги в текстов файл;\n";
		cout << "\t5 - изтриване на компонента\n";
		cout << "\t6 - намиране сумата от цените на книгите, невърнати в срок;\n";
		cout << "\t7 - създаване на масив с данните на всички книги от зададен автор;\n";
		cout << "\t8 - създаване двоичен файл с данните за книги над 200 страници;\n";
		cout << "\t9 - създаване двоичен файл, съдържащ заглавията и цените на\n"
			<< "\t книгите с цена над 10 лв.\n";

		cout << endl << "Посочете операция или 0 за край: "; cin >> KodOp; cout << endl;

		switch (KodOp){
		case '0':break;
		case '1':Prazen(); break;
		case '2':Dobaviane(); break;
		case '3':
			cout << "Име на двоичния файл: "; cin >> GlDvFl;
			Fl_EkranTxtFl(GlDvFl, A);
			break;
		case '4':
			cout << "Име на двоичния файл: "; cin >> GlDvFl;
			Fl_EkranTxtFl(GlDvFl, A, fout);
			break;
		case '5':Iztrivane(); break;
		case '6':cout << "Сумата на цените е " << SumaCeniSrok() << endl; break;
		case '7':
			KnigiAvtor(MasKnig, BrKn);
			for (i = 0; i<BrKn; i++) MasKnig[i].display();
			break;
		case '8':
			cout << "Име на новия двоичен файл: "; cin >> NovDvFl1;
			DvFl_nad200(NovDvFl1);
			cout << endl << "Книги с обем над 200 страници:\n";
			Fl_EkranTxtFl(NovDvFl1, A);
			break;
		case '9':
			cout << "Име на двоичен файл \"заглавия-цени\": "; cin >> NovDvFl2; cout << endl;
			DvFlZagCen(NovDvFl2);
			Fl_EkranTxtFl(NovDvFl2, B);
			break;
		default: cout << "\n\nГрешен код на операция!\n\n\a";
		}
	} while (KodOp != '0');
}