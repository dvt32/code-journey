/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

/* 
Задача 1. 

За група от N (0 <= N <= 30) студента 
се пази информация за К (0<=К<=10) оценки. 

Да се напише програма, която: 
- извежда списък на студентите, подредени по успех в намаляващ ред.

*/

#include "stdafx.h"
#include <iostream>

// Student class
class GroupOfStudents 
{ 
	public: 
		int indexOfStudent; // in order to remember original index of each student after sorting
		int grades[10]; 
		double average;
};

// Sorting methods
void selectionSort(GroupOfStudents arr[], int numberOfStudents){
	int i, j, minIndex, tempIndex;
	double min;

	for (i = 0; i < numberOfStudents - 1; ++i){
		minIndex = i;
		for (j = i + 1; j < numberOfStudents; ++j)
		{
			if (arr[j].average > arr[minIndex].average) {
				minIndex = j;
			}
		}
		if (minIndex > i) { 

			min = arr[minIndex].average; 
			tempIndex = arr[minIndex].indexOfStudent;
			arr[minIndex].average = arr[i].average;
			arr[minIndex].indexOfStudent = arr[i].indexOfStudent;
			arr[i].average = min;
			arr[i].indexOfStudent = tempIndex;
		}
	}
}

void bubbleSort(GroupOfStudents a[], int numberOfStudents){
	bool swapped = true;
	int left = 0, right = numberOfStudents, tempIndex;
	double temp;

	while (swapped){
		swapped = false;
		left++;
		for (int i = 0; i < right - left; ++i){
			if (a[i].average < a[i + 1].average){
				tempIndex = a[i].indexOfStudent;
				temp = a[i].average;
				a[i].average = a[i + 1].average;
				a[i].indexOfStudent = a[i + 1].indexOfStudent;
				a[i + 1].average = temp;
				a[i + 1].indexOfStudent = tempIndex;
				swapped = true;
			}
		}
	}
}

void quickSort(GroupOfStudents arr[], int left, int right) {
	int i = left, j = right, tempIndex;
	double temp, middle = arr[(left + right) / 2].average;

	while (i <= j) {
		while (arr[i].average > middle)	i++;
		while (arr[j].average < middle) j--;
		if (i <= j) {
			tempIndex = arr[i].indexOfStudent;
			temp = arr[i].average;
			arr[i].average = arr[j].average;
			arr[i].indexOfStudent = arr[j].indexOfStudent;
			arr[j].average = temp;
			arr[j].indexOfStudent = tempIndex;
			i++;
			j--;
		}
	};

	if (left < j)
		quickSort(arr, left, j);
	if (i < right)
		quickSort(arr, i, right);
}

// Main function
int main()
{
	// Declarations
	int numberOfStudents, numberOfGrades, i, j;
	GroupOfStudents students[30];

	// Enter data & calculate average of grades for each student
	std::cout << "Enter number of students (1-30): "; std::cin >> numberOfStudents;
	std::cout << "Enter number of grades per student (1-10): "; std::cin >> numberOfGrades; std::cout << std::endl;

	for (i = 0; i < numberOfStudents; ++i){
		students[i].average = 0.0;
		for (j = 0; j < numberOfGrades; ++j){
			std::cout << "Student " << i << ", grade " << j << ": "; std::cin >> students[i].grades[j];
			students[i].average += students[i].grades[j];
		} std::cout << std::endl;
		students[i].average /= numberOfGrades;

		students[i].indexOfStudent = i;
	}

	// Display average of each student
	for (i = 0; i < numberOfStudents; ++i) {
		std::cout << "Student " << i << "'s average: " << students[i].average << std::endl;
	} std::cout << std::endl;

	// Sort GroupOfStudents array
	// selectionSort(students, numberOfStudents);
	// bubbleSort(students, numberOfStudents); 
	quickSort(students, 0, numberOfStudents - 1);

	// Display students & their average in descending order
	std::cout << "Students' average in descending order: " << std::endl;
	for (i = 0; i < numberOfStudents; ++i){
		std::cout << "- Student " << students[i].indexOfStudent << " (" << students[i].average << ")" << std::endl;
	} std::cout << std::endl;


	return 0;
}