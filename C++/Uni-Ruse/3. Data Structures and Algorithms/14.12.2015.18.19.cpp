﻿/* Димитър Валериев Трифонов, КН, 50Б, 146518 */

 /*

 17. Известно е, че в държавата Бимбинистан има пряк път между някои двойки градове.

 Да се състави програма, която:
 - получава информация за градовете и наличните пътища между тях и
 - определя възможно ли е обхождането на всички градове без повторно посещаване на кой да е от тях.

 Като резултат се извежда един възможен ред за обхождане на градовете.

 */

#include "stdafx.h"
#include <iostream>
#include <vector>
#include <map>
#include <stack>
#include <queue>
#include <string>

using namespace std;

int numberOfCities, numberOfDirectPaths;

map<string, vector<string>> directCityPaths;
map<string, vector<string>>::iterator it;

void makeCountry() {
	string startCity, endCity;
	for (int i = 0; i < numberOfDirectPaths; ++i) {
		cout << "Enter start point city name: "; getline(cin, startCity);
		cout << "Enter end point city name: "; getline(cin, endCity); cout << endl;
		directCityPaths[startCity].push_back(endCity);
		//directCityPaths[endCity].push_back(startCity);
	}
}

void checkPaths()
{
	queue<string> myQueue;
	map<string, bool> cityVisited;
	map<string, int> numberOfDirectPathsToCity;
	string endCity, t;
	int numberOfVisitedCities = 0;

	for (it = directCityPaths.begin(); it != directCityPaths.end(); ++it) {
		cityVisited[it->first] = 0;
		numberOfDirectPathsToCity[it->first] = 0;
	}

	for (it = directCityPaths.begin(); it != directCityPaths.end(); ++it) {
		if (directCityPaths[it->first].size() == 0) continue;
		for (int j = 0; j < directCityPaths[it->first].size(); ++j) {
			endCity = directCityPaths[it->first][j];
			numberOfDirectPathsToCity[endCity]++;
		}
	}

	for (it = directCityPaths.begin(); it != directCityPaths.end(); ++it) {
		if (numberOfDirectPathsToCity[it->first] == 0)
			myQueue.push(it->first);
	}

	while (!myQueue.empty())
	{
		for (int i = 0; i < myQueue.size(); i++)
		{
			t = myQueue.front();
			myQueue.pop();
			cityVisited[t] = 1;
			numberOfVisitedCities++;
			for (int j = 0; j < directCityPaths[t].size(); j++)
			{
				endCity = directCityPaths[t][j];
				if (cityVisited[endCity] == 0) numberOfDirectPathsToCity[endCity]--;
				if (numberOfDirectPathsToCity[endCity] == 0) myQueue.push(endCity);
			}
		}
	}

	if (numberOfVisitedCities < numberOfCities) {
		cout << "Not all cities can be visited without going back to one of them!" << endl << endl;
	}
	else {
		cout << "All cities can be visited without going back to one of them!" << endl << endl;
	}
}

void printPath()
{
	stack<string> myStack;
	map<string, bool> cityVisited;
	string startCity, endCity, t;

	for (it = directCityPaths.begin(); it != directCityPaths.end(); ++it) {
		cityVisited[it->first] = 0;
	}

	cout << "Enter start city name: "; getline(cin, startCity);
	cout << "Path (DFS): ";

	myStack.push(startCity);

	while (!myStack.empty())
	{
		t = myStack.top();
		myStack.pop();
		if (cityVisited[t] == 1) continue;
		cityVisited[t] = 1;
		cout << t << " ";
		for (int i = 0; i < directCityPaths[t].size(); i++)
		{
			endCity = directCityPaths[t][i];
			myStack.push(endCity);
		}
	}
}

int main() {
	cout << "Enter number of cities in Bimbinistan: "; cin >> numberOfCities;
	cout << "Enter number of direct paths between cities: "; cin >> numberOfDirectPaths;
	cin.ignore(); cout << endl;

	makeCountry();
	checkPaths();
	printPath();

	return 0;
}

