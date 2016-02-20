/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*

Задача 2.

Да се напише програма, която:
- построява подредено двоично дърво от поредица от числа.

Да се определи:
- височината на дървото.

*/

/* 
	Обяснение на рекурсията 

	H() е опростен вариант на findHeightOfTree(), функция за намиране на височината на двоично дърво

	int H(node *el) 
	{
		if (el == NULL) return 0;
		else return max(H(el->L), H(el->R)) + 1;
	}

	Ако имаме дървото:
		 5
	    / \
	    4  3
	   / \
	  2   1

	Извикваме функцията чрез корена 5. Т.е -> H(5). 
	
	Рекурсията се изпълнява в следната последователност
	- return max(H(4), H(3)) + 1;
	- return max(max(H(2),H(1))+1, H(3)) + 1;
	- return max(max(1,1)+1, 1)) + 1;
	- return 2+1;

	Височината е 3.

	* Височината в програмата няма е 3 с елементи 5,4,3,2,1, защото програмата подрежда дървото при добавяне на възел.

*/

#include "stdafx.h"
#include <iostream>
#include <vector>
#include <algorithm>

// Define a tree element
template <class T>
struct node {
	T inf;
	node<T> *L, *R;
};

// Class definition
template <class T>
class Tree {
public:
	Tree();
	void addNode(node<T> *&root, T);
	void printTreeVisually(node<T> *root);
	int findHeightOfTree(node<T> *root);
	node<T> *root;
	int level;
};

// Constructor
template <class T>
Tree<T>::Tree() { root = NULL; level = 0; }

// Add an element to the tree
template <class T>
void Tree<T>::addNode(node<T> *&el, T valueOfElement)
{
	if (!el)
	{
		el = new node<T>;
		el->inf = valueOfElement;
		el->L = NULL;
		el->R = NULL;
	}
	else
	{
		if (valueOfElement < el->inf) { addNode(el->L, valueOfElement); }
		else if (valueOfElement > el->inf) { addNode(el->R, valueOfElement); }
	}
}

// Print tree visually (root / left / right)
template <class T>
void Tree<T>::printTreeVisually(node<T> *el) {
	if (!el) return;

	std::cout << std::endl;
	if (el != this->root)
	{
		for (int i = 0; i < level - 1; i++)
		{
			std::cout << "    ";
		}
		std::cout << "|___";
	}

	level++;

	std::cout << el->inf;
	printTreeVisually(el->L);
	printTreeVisually(el->R);

	level--;

}

// Find height of tree
template <class T>
int Tree<T>::findHeightOfTree(node<T> *el) {
	if (el == NULL) return 0;
	else return std::max(findHeightOfTree(el->L), findHeightOfTree(el->R)) + 1;
}

// Main method
int main() {
	Tree<int> myTree;
	std::vector<int> elements = { 38, 26, 17, 29, 40, 47, 20, 6, 18, 2, 45, 39, 9, 52, 41, 21, 43 };

	// Add elements to tree
	for (int i = 0; i < elements.size(); ++i)
	{
		myTree.addNode(myTree.root, elements[i]);
	}

	// Print tree visually
	std::cout << "Visual representation of tree (root / left / right): " << std::endl;
	myTree.printTreeVisually(myTree.root);
	std::cout << std::endl << std::endl;

	// Print height of tree
	std::cout << "Height of tree: " << myTree.findHeightOfTree(myTree.root) << std::endl << std::endl;


	return 0;
}