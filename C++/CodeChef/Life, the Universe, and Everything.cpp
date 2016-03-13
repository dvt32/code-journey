/*

Your program is to use the brute-force approach 
in order to find the Answer to Life, the Universe, and Everything. 

More precisely... rewrite small numbers from input to output. 

Stop processing input after reading in the number 42. 
All numbers at input are integers of one or two digits.

Example

Input:
1
2
88
42
99

Output:
1
2
88

*/

#include <iostream>

int main() {
	int number;

	while (true) {
		std::cin >> number;
		if (number == 42) break;
		else std::cout << number << std::endl;
	}

	return 0;
}
