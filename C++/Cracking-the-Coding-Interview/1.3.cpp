// Design an algorithm and write code to remove the duplicate characters in a string.

#include <iostream>
#include <string>
#include <unordered_map>

int main() {
	std::string input = "aabbccd";
	std::string output = "";
	std::unordered_map<char, int> numberOfInstances;

	for (int i = 0; i < input.length(); ++i) {
		char currentCharacter = input[i];
		numberOfInstances[currentCharacter]++;
		if (numberOfInstances[currentCharacter] > 1) {
			continue;
		}
		else {
			output += input[i];
		}
	}

	std::cout << output << std::endl;

	return 0;
}
