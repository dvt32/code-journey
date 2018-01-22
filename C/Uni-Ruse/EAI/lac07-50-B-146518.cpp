/*

КУРСОВА РАБОТА НОМЕР 23

Да се разработят на програмен език C/C++ процедури за:

a)	Създаване на ДИНАМИЧЕН ГРАФ с елементи (с полета) от следния тип:
- "а" -> цял
- "b" -> низ
- "c" -> реален
- "d" -> низ

b)	Прехвърляне на информацията в ДВУСВЪРЗАН СПИСЪК
c)	Сортиране на двусвързания списък

d)	Да се обработи сортирания двусвързан списък като за обработката се използва условие:

... да се разпечата разликата 
    на стойностите на полета "c" и "a" на тези елементи, 
	които съдържат в поле "b" и "d" съответно по 3 и 4 букви.

e)	Запазване на създадената в процедура c) структура като файл.

*/

#include "stdafx.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_STRING_SIZE 50 // максимална дължина на един символен низ в програмата
#define FILE_OUTPUT_PATH "D:\output.txt" // път към изходния файл

/*
	a)	Създаване на ДИНАМИЧЕН ГРАФ с елементи (с полета) от следния тип:
	- "а" -> цял
	- "b" -> низ
	- "c" -> реален
	- "d" -> низ
*/
/*--- ИМПЛЕМЕНТАЦИЯ НА ДИНАМИЧЕН ГРАФ (НЕОРИЕНТИРАН) --*/

// Структура от данни, която съдържа "стойността" на един връх в графа (тоест полетата a,b,c,d за всеки елемент)
struct GraphNodeValue {
	int a;
	char b[MAX_STRING_SIZE];
	float c;
	char d[MAX_STRING_SIZE];
};

// Структура от данни, която представлява един връх в графа (има стойност, дестинация и следващ връх)
struct GraphNode
{
	struct GraphNodeValue value;
    int dest;
    struct GraphNode* next;
};

// Структура от данни, която представлява списък на съседство за върховете в графа
struct AdjList
{
    struct GraphNode* head;  // указател към главата на списъка
};

// Структура от данни, която представлява графа. 
// Един граф е масив от списъци на съседство. 
// Размерът на масива ще е V (брой върхове в графа)
struct Graph
{
    int V;
    struct AdjList* array;
};

// Масив, който съдържа стойност за всеки връх от графа
struct GraphNodeValue node_values[] =
{
	{ 15, "asdf", 2.04, "sometext" },
	{ 16, "qwerty", 5.04, "anothertext" },
	{ 17, "sadaf", 6.04, "test" },
	{ 18, "vvv", 5.04, "moretests" },
	{ 19, "SDASD", 5.04, "moretestASDF" }
};

// Размер на графа (брой върхове) - определя се от броя елементи в node_values[]
#define GRAPH_SIZE sizeof(node_values) / sizeof(node_values[0])

// Функция, която създава нов връх в графа
struct GraphNode* newGraphNode(int dest, struct GraphNodeValue value)
{
    struct GraphNode* newNode = (struct GraphNode*) malloc(sizeof(struct GraphNode)); // заделяне на памет за новия връх
	newNode->value = value;
    newNode->dest = dest;
    newNode->next = NULL;
    return newNode;
}
 
// Функция, която създава граф с V върха
struct Graph* createGraph(int V)
{
    struct Graph* graph = (struct Graph*) malloc(sizeof(struct Graph)); // заделяне на памет за графа
    graph->V = V;
 
    // Създай масив от списъци на съседство.  Размерът на масива ще е V
    graph->array = (struct AdjList*) malloc(V * sizeof(struct AdjList));
 
	// Инициализирай всеки списък на съседство като направиш главата NULL
    for (int i = 0; i < V; ++i) {
        graph->array[i].head = NULL;
	}
 
    return graph;
}
 
// Функция, която добавя ребро в неориентиран граф 
void addEdge(struct Graph* graph, int src, int dest)
{
	// Добави ребро от връх с номер 'src' до връх с номер 'dest'. 
	// Нов връх се добавя към списъка на съседство на връх 'src'. Върхът се добавя в началото.
    struct GraphNode* newNode = newGraphNode(dest, node_values[src]);
    newNode->next = graph->array[src].head;
    graph->array[src].head = newNode;
 
	// Понеже графът е неориентиран, добави ребро и от 'dest' до 'src'
	newNode = newGraphNode(src, node_values[dest]);
    newNode->next = graph->array[dest].head;
    graph->array[dest].head = newNode;
}

// Функция, която извежда графа под формата на списък на съседство
void printGraph(struct Graph* graph)
{
    for (int i = 0; i < graph->V; ++i)
	{
        struct GraphNode* temp = graph->array[i].head;
        printf("\nAdjacency list of node %d (%d %s %f %s)\n", 
			i, 
			temp->value.a, 
			temp->value.b, 
			temp->value.c, 
			temp->value.d
		);

        while (temp)
        {
            printf("-> %d (%d %s %f %s)\n", 
				temp->dest, 
				graph->array[temp->dest].head->value.a,
				graph->array[temp->dest].head->value.b,
				graph->array[temp->dest].head->value.c,
				graph->array[temp->dest].head->value.d
			);
            temp = temp->next;
        }
    }
}


/*
	b) Прехвърляне на информацията в ДВУСВЪРЗАН СПИСЪК
*/
/*--- ИМПЛЕМЕНТАЦИЯ НА ДВУСВЪРЗАН СПИСЪК ---*/

// Структура от данни, която представлява елемент в двусвързания списък. 
// Всеки елемент притежава полета a,b,c,d и указател към предишния и следващия елемент в списъка
struct ListNode 
{
	int a;
	char b[MAX_STRING_SIZE];
	float c;
	char d[MAX_STRING_SIZE];

	struct ListNode* prev;
	struct ListNode* next;
};

// Глобална променлива - указател към елемента глава на списъка
struct ListNode* head; 

// Функция, която създава нов елемент в списъка и връща указател към него
struct ListNode* getNewNode(int a, char b[], float c, char d[]) 
{
	struct ListNode* newNode = (struct ListNode*) malloc(sizeof(struct ListNode));

	newNode->a = a;
	strncpy_s(newNode->b, b, sizeof(newNode->b));
	newNode->c = c;
	strncpy_s(newNode->d, d, sizeof(newNode->d));

	newNode->prev = NULL;
	newNode->next = NULL;
	return newNode;
}

// Функция, която вмъква нов елемент в началото на списъка
void insertAtHead(int a, char b[], float c, char d[]) 
{
	struct ListNode* newNode = getNewNode(a, b, c, d);

	if (head == NULL) {
		head = newNode;
		return;
	}

	head->prev = newNode;
	newNode->next = head;
	head = newNode;
}

// Функция, която вмъква нов елемент в края на списъка
void insertAtTail(int a, char b[], float c, char d[]) 
{
	struct ListNode* newNode = getNewNode(a, b, c, d);

	if (head == NULL) {
		head = newNode;
		return;
	}

	// Отиди на последния елемент
	struct ListNode* temp = head;
	while (temp->next != NULL) {
		temp = temp->next; 
	}

	temp->next = newNode;
	newNode->prev = temp;
}

// Функция, която извежда всички елементи в списъка от първия до последния
void printList() 
{
	struct ListNode* temp = head;

	printf("Forward Traversal: \n");
	while (temp != NULL) {
		printf("-> %d %s %f %s\n", temp->a, temp->b, temp->c, temp->d);
		temp = temp->next;
	}

	printf("\n");
}

// Функция, която извежда всички елементи в списъка от последния до първия (в обратен ред)
void printListReverse() 
{
	struct ListNode* temp = head;

	if (temp == NULL) {
		return; // списъкът е празен, излез от функцията
	}

	// Отиди на последния елемент
	while (temp->next != NULL) {
		temp = temp->next;
	}

	// Обхождане на списъка
	printf("Reverse Traversal: \n");
	while (temp != NULL) {
		printf("-> %d %s %f %s\n", temp->a, temp->b, temp->c, temp->d);
		temp = temp->prev;
	}
}

// Функция, която прехвърля данни от неориентиран граф в двусвързан списък
void transferGraph(struct Graph* graph) 
{
    for (int i = 0; i < graph->V; ++i)
	{
        struct GraphNode* graphNode = graph->array[i].head;
        insertAtTail(graphNode->value.a, graphNode->value.b, graphNode->value.c, graphNode->value.d);
    }
	printf("Successfully transferred graph node values to list!\n\n");
}


/*
	c)	Сортиране на двусвързания списък
*/
/*--- ИМПЛЕМЕНТАЦИЯ НА СОРТИРАНЕ НА ДВУСВЪРЗАН СПИСЪК (С QUICKSORT) ПО СТОЙНОСТТА НА ПОЛЕТО 'А' НА ЕЛЕМЕНТ В СПИСЪКА ---*/

// Функция, която връща последния елемент от двусвързания списък
struct ListNode* getLastNode(ListNode* head) 
{
    while (head && head->next) {
		head = head->next;
	}
    return head;
}

// Функция, която разменя два елемента от списъка
void swap(struct ListNode* first_node, struct ListNode* second_node) 
{
	// Размени стойностите за полето 'а'
	int a_temp = first_node->a;
	first_node->a = second_node->a;
	second_node->a = a_temp;

	// Размени стойностите за полето 'b'
	const int B_SIZE = ( sizeof(first_node->b) / sizeof(first_node->b[0]) );
	char b_temp[B_SIZE];
	strncpy_s( b_temp, first_node->b, sizeof(b_temp) );
	strncpy_s( first_node->b, second_node->b, sizeof(first_node->b) );
	strncpy_s( second_node->b, b_temp, sizeof(second_node->b) );

	// Размени стойностите за полето 'c'
	float c_temp = first_node->c;
	first_node->c = second_node->c;
	second_node->c = c_temp;

	// Размени стойностите за полето 'd'
	const int D_SIZE = ( sizeof(first_node->d) / sizeof(first_node->d[0]) );
	char d_temp[D_SIZE];
	strncpy_s( d_temp, first_node->d, sizeof(d_temp) );
	strncpy_s( first_node->d, second_node->d, sizeof(first_node->d) );
	strncpy_s( second_node->d, d_temp, sizeof(second_node->d) );
}
 
/* 
Функция, която:
- избира последния елемент от списъка за осов
- поставя го на правилната му позиция в сортирания масив
- поставя всички по-малки елементи (по-малки от осовия) отляво на осовия
- поставя всички по-големи елементи (по-големи от осовия) отдясно на осовия
*/
ListNode* partition(ListNode* l, ListNode* h) 
{
    // Задаване на осовата стойност (тази на полето 'а')
    int pivot = h->a;
 
    // Аналогично на i = l-1
    ListNode* i = l->prev;
 
    // Аналогично на "for (int j = l; j <= h-1; j++)"
    for (ListNode* j = l; 
		 j != h; 
		 j = j->next) 
	{
        if (j->a <= pivot) {
            i = (i == NULL) ? l : i->next; // аналогично на i++
			swap(i, j);
        }
    }
    i = (i == NULL) ? l : i->next; // аналогично на i++
	swap(i, h);

    return i;
}

// Рекурсивна имплементация на QuickSort за двусвързан списък
void _quickSort(struct ListNode* l, struct ListNode* h) 
{
    if (h != NULL && l != h && l != h->next) {
        struct ListNode *p = partition(l, h);
        _quickSort(l, p->prev);
        _quickSort(p->next, h);
    }
}
 
// Главната функция за сортиране на двусвързан списък. Тя най-вече извиква _quickSort()
void quickSort(struct ListNode *head)
{
    // Вземи последния елемент
    struct ListNode *h = getLastNode(head);
 
    // Извикай рекурсивната quickSort функция
    _quickSort(head, h);

	printf("List sorted successfully!\n\n");
}


/*
	d)	Да се обработи сортирания двусвързан списък като за обработката се използва условие:

	... да се разпечата разликата 
		на стойностите на полета "c" и "a" на тези елементи, 
		които съдържат в поле "b" и "d" съответно по 3 и 4 букви.
*/
// Функция, която извежда гореописаната разлика
void printListDifference() {
	struct ListNode* temp = head;

	printf("Differences found: \n");
	while (temp != NULL) {
		if ( strlen(temp->b) == 3 && strlen(temp->d) == 4) {
			printf("-> %d %s %f %s \n", temp->a, temp->b, temp->c, temp->d);
			printf("\tb = %s (len 3), d = %s (len 4)\n", temp->b, temp->d);
			printf("\tc = %f, a = %d\n", temp->c, temp->a);
			printf("\tc - a = %f\n", (temp->c - temp->a) );
		}
		
		temp = temp->next;
	}
}


/*
	e)	Запазване на създадената в процедура c) структура като файл.
*/
// Функция, която запазва информацията от двусвързания списък в текстов файл.
void saveListToFile() {
	FILE *f = fopen(FILE_OUTPUT_PATH, "w"); // "w" - отвори файла в режим за записване на инфирмация в него
	if (f == NULL) {
		printf("Error opening file!\n");
		return;
	}

	struct ListNode* temp = head;
	while (temp != NULL) {
		fprintf(f, "%d %s %f %s\n", temp->a, temp->b, temp->c, temp->d);
		temp = temp->next;
	}

	printf("File saved successfully!\n\n");
}


/*--- ГЛАВНА ФУНКЦИЯ ---*/
int main() {

	printf("--- 1. CREATE GRAPH ---\n");

	// Създай неориентиран граф с GRAPH_SIZE върха
    struct Graph* graph = createGraph(GRAPH_SIZE);

	// Добави ребра в неориентирания граф
    addEdge(graph, 0, 1);
    addEdge(graph, 0, 4);
    addEdge(graph, 1, 2);
    addEdge(graph, 1, 3);
    addEdge(graph, 1, 4);
    addEdge(graph, 2, 3);
    addEdge(graph, 3, 4);
 
	// Изведи графа на конзолата под формата на списък на съседство
    printGraph(graph);

	printf("\n--- 2. CREATE LIST ---\n\n");

	// Инициализирай празен списък с глава NULL
	head = NULL;

	// Вмъкни елементи в края на списъка
	insertAtTail(2, "hello", 3.14, "test");
	insertAtTail(1, "baba", 2.05, "allo");
	insertAtTail(3, "grr", 1.01, "huba");
	insertAtTail(2, "tes", 5.432, "CAPS");

	// Изведи елементите на списъка в прав и обратен ред
	printList(); 
	printListReverse();

	printf("\n--- 3. TRANSFER GRAPH ELEMENTS TO LIST ---\n\n");

	// Прехвърли данните от неориентирания граф в двусвързания списък
	transferGraph(graph);

	// Пак изведи елементите на списъка в прав и обратен ред
	printList(); 
	printListReverse();
	
	printf("\n--- 4. SORT LIST ---\n\n");

	// Сортирай списъка
	quickSort(head);

	// Пак изведи елементите на списъка в прав и обратен ред
	printList(); 
	printListReverse();

	printf("\n--- 5. PRINT DIFFERENCES ---\n\n");

	// Изведи разликата на полетата 'c' и 'а' на елементи в списъка, чиито полета 'b' и 'd' имат дължина съответно 3 и 4.
	printListDifference();

	printf("\n--- 6. SAVE LIST TO FILE ---\n\n");

	// Запази данните от списъка във файл
	saveListToFile();

	return 0;
}
