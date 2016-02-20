/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/*

Задача 3.

Да се напише:
- функцията за добавяне на възел в подредено двоично дърво,
- така че да се изведе информация за броя на възлите в него.

*/

/* Обяснение на рекурсията:

N() е опростен вариант на findNumberOfNodes() и намира броя на възлите в едно двоично дърво.

int N(node *el)
{
if (el == NULL) return 0;
else if (el->L == NULL && el->R == NULL) return 1;
else return N(el->L) + N(el->R) + 1;
}

Ако имаме дървото:

5
/ \
4   3
/ \
2   1

1. Първо, извикваме функцията със стойността на корена. Т.е -> N(5);
2. При N(5):
- el = 5 (не е NULL), затова НЕ връщаме 0
- el->L = 4 и el->R = 5 (не са NULL), , затова НЕ връщаме 1
- връщаме N(el->L) + N(el->R) + 1

Затова остава:
return N(4) + N(3) + 1;

3. При N(4) + N(3) + 1;
- разглеждаме само N(4)
- el = 4 (не е NULL), затова НЕ връщаме 0
- el->L = 2 и el->R = 1 (не са NULL), , затова НЕ връщаме 1
- връщаме N(el->L) + N(el->R) + 1
- добавяме и останалата част от предишното извикване, която е N(3) + 1

Затова остава:
return N(2) + N(1) + 1 + N(3) + 1;

4. При N(2) + N(1) + 1 + N(3) + 1;
- разглеждаме само N(2)
- el = 2 (не е NULL), затова НЕ връщаме 0
- el->L = NULL и el->R = NULL, , затова ВРЪЩАМЕ 1
- добавяме и останалата част от предишното извикване, която е N(1) + 1 + N(3) + 1

Затова остава:
return 1 + N(1) + 1 + N(3) + 1;

5. При 1 + N(1) + 1 + N(3) + 1;
- разглеждаме само N(1)
- el = 1 (не е NULL), затова НЕ връщаме 0
- el->L = NULL и el->R = NULL, , затова ВРЪЩАМЕ 1
- добавяме и останалата част от предишното извикване, която е 1 + 1 + N(3) + 1

Затова остава:
return 1 + 1 + 1 + N(3) + 1;

6. При 1 + 1 + 1 + N(3) + 1;
- разглеждаме само N(3)
- el = 3 (не е NULL), затова НЕ връщаме 0
- el->L = NULL и el->R = NULL, , затова ВРЪЩАМЕ 1
- добавяме и останалата част от предишното извикване, която е 1 + 1 + 1 + 1

Затова остава:
return 1 + 1 + 1 + 1 + 1;

7. Броят на възлите е 5.

*/

#include "stdafx.h"
#include <iostream>
#include <vector>

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
	int findNumberOfNodes(node<T> *root);
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

// Find number of nodes in tree
template <class T>
int Tree<T>::findNumberOfNodes(node<T> *el) {
	if (el == NULL) return 0;
	else return findNumberOfNodes(el->L) + findNumberOfNodes(el->R) + 1;
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

	// Print number of nodes in tree
	std::cout << "Number of nodes in tree: " << myTree.findNumberOfNodes(myTree.root) << std::endl << std::endl;


	return 0;
}