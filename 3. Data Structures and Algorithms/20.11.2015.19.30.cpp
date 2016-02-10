﻿/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

 /*

 Задача 1. Да се напише програма, която преобразува произволен масив в пирамида.

 */

#include "stdafx.h"
#include <iostream>

struct MinHeap
{
	int heapSize;	// size of heap
	int arraySize; // size of input array
	int *data;	// dynamic array, which will store the values of the MinHeap

	// Heap constructor
	MinHeap(int sizeOfHeap)
	{
		data = new int[sizeOfHeap];
		heapSize = 0; // initial heap size, which will grow as each element is added
		arraySize = sizeOfHeap;
	};

	// Heap destructor
	~MinHeap()
	{
		delete[] data;
	}

	// Heap struct member functions
	int getLeftChildIndex(int i) { return 2 * i + 1; }
	int getRightChildIndex(int i) { return 2 * i + 2; }
	int getParentIndex(int i) { return (i - 1) / 2; }
	int getMinimum() { if (isEmpty()) return -1; else return data[0]; }
	bool isEmpty() { return (heapSize == 0); }

	void heapify(int nodeIndex)
	{
		int parentIndex, temp;
		if (nodeIndex != 0)
		{
			parentIndex = getParentIndex(nodeIndex);
			// If parent node's value is bigger than current node's value, switch their places
			if (data[parentIndex] > data[nodeIndex])
			{
				temp = data[parentIndex];
				data[parentIndex] = data[nodeIndex];
				data[nodeIndex] = temp;
				// after switching, try to heapify the current node's parent
				heapify(parentIndex);
			}
		}
	}

	void addToHeap(int value)
	{
		// if heap size is equal to input array size, an overflow error will occur
		if (heapSize != arraySize)
		{
			heapSize++;
			data[heapSize - 1] = value;
			heapify(heapSize - 1);
		}
	}

	void printHeap() 
	{
		for (int i = 0; i < heapSize; ++i) {
			std::cout << data[i] << " ";
		}
	}
};

int main() {
	// Declare array with random values and get its size
	int arr[] = { 7, 12, 36, 24, 5, 19, 11, 3, 17 };
	int sizeOfArr = sizeof(arr) / sizeof(arr[0]);

	// Heap declaration
	MinHeap myHeap(sizeOfArr);

	// Add each element from arr[] to the heap
	for (int i = 0; i < sizeOfArr; ++i) {
		myHeap.addToHeap(arr[i]);
	}

	// Display end result
	myHeap.printHeap();

	return 0;
}