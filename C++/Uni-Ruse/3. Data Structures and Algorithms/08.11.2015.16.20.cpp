/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*

Задача 1.

Да се напише програма, която:
- построява подредено двоично дърво от поредица от числа.
- извежда числата в сортиран ред (нарастващ / намаляващ).
- намира броя на листата на дървото.

*/

#include "stdafx.h"
#include <iostream>
#include <vector>

/* Binary tree implementation BEGIN */

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
	~Tree();
	void addNode(node<T> *&root, T);
	void printTree(node<T> *root, bool sortOrder); // sortOrder -> 0 - ascending, 1 - descending
	void printTreeVisually(node<T> *root);
	int findNumberOfLeafNodes(node<T> *root);
	node<T> *root;
	node<T> *deleteNode(node<T> *root, T);
	int level;
private:
	void deleteTree(node<T> *&root);
	node<T> *findMinElement(node<T> *root);
};

// Constructor & destructor
template <class T>
Tree<T>::Tree() { root = NULL; level = 0; }
template <class T>
Tree<T>::~Tree() { deleteTree(root); }

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

// Delete an element from the tree
template <class T>
node<T>* Tree<T>::deleteNode(node<T> *el, T valueOfElement)
{
	node<T> *t = NULL, *q = NULL;
	if (!el) return NULL;
	else if (valueOfElement < el->inf) el->L = deleteNode(el->L, valueOfElement);
	else if (valueOfElement > el->inf) el->R = deleteNode(el->R, valueOfElement);
	else if (el->L && el->R)
	{
		t = findMinElement(el->R);
		el->inf = t->inf;
		el->R = deleteNode(el->R, el->inf);
	}
	else
	{
		t = el;
		if (el->L == NULL) q = el->R;
		if (el->R == NULL) q = el->L;
		delete t;
		return q;
	}

	return el;
}

// Print tree
template <class T>
void Tree<T>::printTree(node<T> *el, bool sortOrder)
{
	if (sortOrder == 0) { // ascending order (left/root/right)
		if (el) {
			printTree(el->L, 0);
			std::cout << el->inf << " ";
			printTree(el->R, 0);
		}
	}
	if (sortOrder == 1) { // descending order (right/root/left)
		if (el) {
			printTree(el->R, 1);
			std::cout << el->inf << " ";
			printTree(el->L, 1);
		}
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

// Find the smallest element in the tree
template <class T>
node<T>* Tree<T>::findMinElement(node<T> *el)
{
	if (!el) return NULL;
	else if (el->L == NULL) return el;
	else return findMinElement(el->L);
}

// Delete entire tree
template <class T>
void Tree<T>::deleteTree(node<T> *&el)
{
	if (el)
	{
		deleteTree(el->L);
		deleteTree(el->R);
		delete el;
		el = NULL;
	}
}

// Find number of leaf nodes
template <class T>
int Tree<T>::findNumberOfLeafNodes(node<T> *el)
{
	if (el == NULL) return 0;
	if (el->L == NULL & el->R == NULL) return 1;
	else return findNumberOfLeafNodes(el->L) + findNumberOfLeafNodes(el->R);
}

/* Binary tree implementation END */

// Main method
int main() {
	Tree<int> myTree;
	std::vector<int> elements = { 38, 26, 17, 29, 40, 47, 20, 6, 18, 2, 45, 39, 9, 52, 41, 21, 43 };
	int numberOfLeafNodes = 0;

	// Add elements to tree
	for (int i = 0; i < elements.size(); ++i)
	{
		myTree.addNode(myTree.root, elements[i]);
	}

	// Delete elements 17 & 47, add 11
	myTree.deleteNode(myTree.root, 17);
	myTree.deleteNode(myTree.root, 47);
	myTree.addNode(myTree.root, 11);

	// Print tree visually
	std::cout << "Visual representation of tree (root / left / right): " << std::endl;
	myTree.printTreeVisually(myTree.root);
	std::cout << std::endl << std::endl;

	// Print tree in ascending order
	std::cout << "Tree nodes in ascending order (left / root / right): " << std::endl << std::endl;
	myTree.printTree(myTree.root, 0);
	std::cout << std::endl << std::endl;

	// Print tree in descending order
	std::cout << "Tree nodes in descending order (right / root / left): " << std::endl << std::endl;
	myTree.printTree(myTree.root, 1);

	// Print number of leaf nodes
	std::cout << std::endl << std::endl << "Number of leaf nodes: " << myTree.findNumberOfLeafNodes(myTree.root) << std::endl;

	return 0;
}