// https://www.hackerrank.com/challenges/c-tutorial-stringstream

#include <sstream>
#include <vector>
#include <iostream>

std::vector<int> parseInts(std::string str) {
	std::vector<int> integers;
	std::stringstream ss(str);
	while (ss) {
		int currentInteger;
		char currentComma;
		ss >> currentInteger >> currentComma;
		integers.push_back(currentInteger);
	}
	return integers;
}

int main() {
	std::string str;

	std::cin >> str; // std::getline is not needed, because of input format.

	std::vector<int> integers = parseInts(str);

	for (int i = 0; i < integers.size(); ++i) {
		std::cout << integers[i] << std::endl;
	}

	return 0;
}
