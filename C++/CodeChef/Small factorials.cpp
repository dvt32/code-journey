/*

You are asked to calculate factorials of some small positive integers.

Input

An integer t, 1<=t<=100, denoting the number of testcases,
followed by t lines, each containing a single integer n, 1<=n<=100.

Output

For each integer n given at input, display a line with the value of n!
Example

Sample input:
4
1
2
5
3

Sample output:
1
2
120
6

*/

#include <iostream>
#define MAX_DIGITS 200

void calculateFactorial(int n) {
	int a[MAX_DIGITS];
	int numberOfDigits;
	int digitByDigitProduct;
	int carryValue;

	a[0] = 1;
	numberOfDigits = 1;
	carryValue = 0;

	// Get factorial digits
	for (int i = 1; i <= n; ++i)
	{
		for (int j = 0; j < numberOfDigits; ++j)
		{
			digitByDigitProduct = a[j] * i + carryValue;    // containts digit by digit product + carry value
			a[j] = digitByDigitProduct % 10;				        // contains the digit to store in position j
			carryValue = digitByDigitProduct / 10;			    // contains the carry value that will be stored on later indexes
		}
	
		while (carryValue > 0)
		{
			a[numberOfDigits] = carryValue % 10;
			carryValue /= 10;
			numberOfDigits++;
		}
	}

	// Print end result (factorial)
	for (int i = numberOfDigits-1; i >= 0; --i)
	{
		std::cout << a[i];
	} 
	
	std::cout << std::endl;
}

int main() {
	int t, n;

	std::cin >> t;
	if (t >= 1 && t <= 100) 
	{
		for (int i = 1; i <= t; ++i) {
			std::cin >> n;
			if (n >= 1 && n <= 100)
			{
				calculateFactorial(n);
			}
		}
	}

	return 0;
}
