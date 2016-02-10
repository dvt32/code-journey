// dvt @ Visual C++ 2008 Express Edition

/* 

4.2. Да се състави програма, която съхранява в масив следните данни за книгите в една 
библиотека:
-инвентарен номер - низ до 6 знака;
-автор - низ до 20 знака;
-заглавие - низ до 30 знака;
-обем на книгата (брой страници)- цяло число;
-цена - реално число;
-година на издаване

и извършва следните операции, избирани от меню:
-добавя към файла данните за книга;
-извежда на екрана данните за всички книги с цена под 15 лв;
-създава текстов файл, съдържащ заглавията и цените на книгите над 10 лв.
-създава двоичен файл  с данните за книги над 200 страници

*/

#include "stdafx.h"
#include <iostream>
using namespace std;
#include <fstream>
#include <string>
#include <conio.h>

ofstream fout; 
ifstream fin;

class Library{
	protected:
		char invNumber[7];
		char author[21];
		char title[31];
		int numberOfPages;
		double price;
		int publishYear;
	public:
		Library(){}
		void cinInfo();
		void printInfo(ostream&);

		friend void binAdd(string, Library);
		friend void createTxtFile(string, Library);
		friend void printInfo15(string, Library);
		friend void createBinFile(string, Library);
};

// cinInfo()
void Library::cinInfo(){
	cin.ignore();
	cout << "Inventory number: "; cin.getline(invNumber, 7);
	cout << "Author: "; cin.getline(author, 21);
	cout << "Title: "; cin.getline(title, 31);
	cout << "Number of pages: "; cin >> numberOfPages;
	cout << "Price: "; cin >> price;
	cout << "Year of publication: "; cin >> publishYear;
}

// printInfo()
void Library::printInfo(ostream& out){
	out << "Inventory number: " << invNumber << endl;
	out << "Author: " << author << endl;
	out << "Title: " << title << endl;
	out << "Number of pages: " << numberOfPages << endl;
	out << "Price: " << price << endl;
	out << "Year of publication: " << publishYear << endl << endl;
}

// printInfo15()
void printInfo15(string fileName, Library obj){
	fin.open(fileName.c_str(), ios::in|ios::binary);
	while (fin.read((char*) &obj, sizeof(obj))){
		if (obj.price < 15) obj.printInfo(cout);
	}
	fin.close();
}

// binAdd()
void binAdd(string fileName, Library obj){
	fout.open(fileName.c_str(), ios::app|ios::binary);
	obj.cinInfo();
	fout.write((char*) &obj, sizeof(obj));
	fout.close();
}

// createTxtFile()
void createTxtFile(string inputFileName, Library obj){
	cin.ignore();

	string outputFileName;
	cout << "Enter text file name: "; getline(cin, outputFileName);
	
	fin.open(inputFileName.c_str(), ios::in | ios::binary);
	fout.open(outputFileName.c_str(), ios::out);
	while (fin.read((char*) &obj, sizeof(obj))){
		if (obj.price > 10){
			obj.printInfo(fout);
		}
	}
	fout.close();
	fin.close();
}

// createBinFile()
void createBinFile(string inputFileName, Library obj){
	cin.ignore();

	string outputFileName;
	cout << "Enter new binary file name: "; getline(cin, outputFileName);

	fin.open(inputFileName.c_str(), ios::in|ios::binary);
	fout.open(outputFileName.c_str(), ios::out|ios::binary);
	while (fin.read((char*) &obj, sizeof(obj))){
		if (obj.numberOfPages > 200){
			fout.write((char*) &obj, sizeof(obj));
		}
	}
	fout.close();
	fin.close();

}


int _tmain(int argc, _TCHAR* argv[])
{
	system("chcp 1251");

	// Declarations
	string binFileName; 
	int menuCode;
	Library book;

	// Enter binary file name
	cout << "Name of main binary file: "; getline(cin, binFileName);

	// Menu
	do
	{
		cout << endl << "MENU: " << endl;
		cout << "- [1] Добави към файла данните за книга " << endl;
		cout << "- [2] Изведи на екрана данните за всички книги с цена под 15 лв." << endl;
		cout << "- [3] Създай текстов файл, съдържащ данните на книгите с цена над 10 лв." << endl;
		cout << "- [4] Създай двоичен файл  с данните за книги над 200 страници." << endl << endl;

		cout << "Enter operation code or 0 to end program: "; cin >> menuCode; cout << endl;

		switch (menuCode){
			case 0: break;
			case 1: binAdd(binFileName, book); break;
			case 2: printInfo15(binFileName, book); break;
			case 3: createTxtFile(binFileName, book); break;
			case 4: createBinFile(binFileName, book); break;
			default: break;
		}
	} while (menuCode != 0);

	return 0;
}

