/*

The purpose of this problem is to verify 
whether the method you are using to read input data 
is sufficiently fast to handle problems branded with the enormous Input/Output warning. 

You are expected to be able to process at least 2.5MB of input data per second at runtime.

Input
====
The input begins with two positive integers n & k (n, k <= 10^7).     
The next n lines of input contain one positive integer ti, not greater than 10^9, each.

note:
- 10^7 = 10 000 000
- 10^9 = 1 000 000 000

Output
===
Write a single integer to output, denoting how many integers ti are divisible by k.

Example

Input:
	7 3
	1
	51
	966369
	7
	9
	999996
	11

Output:
	4

*/

#include <iostream>
#include <math.h>

int main() {
	unsigned int n, k;
	bool inputIsValid = false;
	int t_i;
	int divisible_by_k_count = 0;

	// Read input
	std::cin >> n;
	std::cin >> k;
	
	// Check if input is correct
	if (n <= pow(10, 7) && k <= pow(10, 7)) 
	{
		inputIsValid = true;
	}

	// Get number of integers divisible by 'k'
	for (int i = 1; i <= n; ++i) 
	{
		std::cin >> t_i;
		if (t_i <= pow(10, 9) && t_i % k == 0) 
		{
			divisible_by_k_count++;
		}
	}

	// Print end result
	std::cout << divisible_by_k_count << std::endl;

	return 0;
}
