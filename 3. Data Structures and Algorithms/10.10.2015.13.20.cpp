/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/* 

Задача 1. Да се напише програма, която:
- преобразува аритметичен израз, представен в инфиксна форма, в постфиксна форма (обратен полски запис). 

*/

#include "stdafx.h"
#include <iostream>
#include <string>
#include <stack>

int main() {
	// 1. Четем входния низ
	std::string input;
	std::cout << "Enter arithmetic expression: "; std::getline(std::cin, input);

	// 2. Инициализираме изходен низ и стек
	std::string output = "";
	std::stack<char> myStack;

	// 3. Добавяме '(' в стека
	myStack.push('(');

	// 4. Обхождаме низа по символи и ако текущият символ е:
	for (int i = 0; i < input.length(); ++i) {
		// ')' - добавяме в стека
		if (input.at(i) == '(') { myStack.push('('); }
		// операнд - добавяме в изходния низ
		if ((input.at(i) >= 'a' && input.at(i) <= 'z') || (input.at(i) >= 'A' && input.at(i) <= 'Z'))
		{
			output += input.at(i);
		}
		/* знак с по-нисък приоритет ('+', '-') 
			- отнемаме от стека ВСИЧКИ знаци за операции с ПО-ВИСОК ПРИОРИТЕТ ('*', '/'), разположени до най-близката '('
			- записваме ги в изходния низ
			- добавяме в стека първоначалният знак с нисък приоритет ('+' или '-')
		*/
		if (input.at(i) == '+' || input.at(i) == '-'){
			while (myStack.top() == '*' || myStack.top() == '/') { 
				output += myStack.top();
				myStack.pop();
			}
			myStack.push(input.at(i));
		}
		// '*', '/' - записваме в стека
		if (input.at(i) == '*' || input.at(i) == '/') { myStack.push(input.at(i)); }
		// ')' - отнемаме от стека и записваме в изходния низ до първата '('. Премахваме отварящата скоба от стека.
		if (input.at(i) == ')') {
			while (myStack.top() != '('){
				output += myStack.top();
				myStack.pop();
			} myStack.pop(); // премахване на '('
		}		
	}

	// 5. След края на низа прехвърляме останалите знаци за операции в изходния низ до началната '('.
	while (myStack.top() != '(') {
		output += myStack.top();
		myStack.pop();
	}

	// 6. Извеждаме изходния низ. При коректна работа, той съответства на израза в обратен полски запис.
	std::cout << "Reverse Polish notation: " << output << std::endl << std::endl;

	return 0;
}