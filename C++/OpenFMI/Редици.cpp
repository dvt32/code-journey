// http://judge.openfmi.net:9280/practice/get_problem_description?contest_id=2&problem_id=2

#include <iostream>
#include <climits>
#include <math.h>

int main() {
	int n;
	int numberOfSequences = 0;
	
	// Enter 'n'
	std::cin >> n;
	if (n < 1 || n > std::pow(10, 5)) {
		return 0;
	}

	// Enter array elements
	int *a = new int[n];
	for (int i = 0; i < n; ++i) {
		std::cin >> a[i];
		if (a[i] < std::pow(-10, 9) || a[i] > std::pow(10, 9)) {
			delete[] a;
			return 0;
		}
	}

	// Extract subarrays
	for (int i = 0; i < n; ++i) {
		int maxElement = std::numeric_limits<int>::min();
		int minElement = std::numeric_limits<int>::max();
		for (int j = i; j < n; ++j) {
			if (a[j] > maxElement) {
				maxElement = a[j];
			}
			if (a[j] < minElement) {
				minElement = a[j];
			}
			if (maxElement == minElement) {
				numberOfSequences++;
			}
		}
	}

	// Print end result (number of sequences)
	std::cout << numberOfSequences << std::endl;

	// Clear up memory
	delete[] a;

	return 0;
}
