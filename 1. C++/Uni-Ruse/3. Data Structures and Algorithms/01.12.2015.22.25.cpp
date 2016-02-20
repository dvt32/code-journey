﻿/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

 /*

 Задача 2. Да се напише програма, която сортира масива като използва структурата пирамида.

 */

#include "stdafx.h"
#include <iostream>

int total;

void heapify(int arr[], int i)
{
	// Get index of left child & right child and 
	int leftChildIndex = i * 2;
	int rightChildIndex = leftChildIndex + 1;
	int maxNodeIndex = i;
	
	// Find max node index
	if (leftChildIndex <= total && arr[leftChildIndex] > arr[maxNodeIndex]) {
		maxNodeIndex = leftChildIndex;
	}
	if (rightChildIndex <= total && arr[rightChildIndex] > arr[maxNodeIndex]) {
		maxNodeIndex = rightChildIndex;
	}

	// If left or right child's value is the max value, switch it with the parent's value and then heapify the child
	if (maxNodeIndex != i) {
		std::swap(arr[i], arr[maxNodeIndex]);
		heapify(arr, maxNodeIndex);
	}
}

void heapSort(int arr[], int size)
{
	total = size - 1;

	for (int i = total / 2; i >= 0; i--)
		heapify(arr, i);

	for (int i = total; i > 0; i--) {
		std::swap(arr[0], arr[i]);
		total--;
		heapify(arr, 0);
	}
}

int main() {
	// Declare array with random values and get its size
	int arr[] = { 7, 12, 36, 24, 5, 19, 11, 3, 17 };
	int sizeOfArr = sizeof(arr) / sizeof(arr[0]);

	// Sort array using heap
	heapSort(arr, sizeOfArr);

	// Display end result
	for (int i = 0; i < sizeOfArr; ++i) {
		std::cout << arr[i] << " ";
	}

	return 0;
}

