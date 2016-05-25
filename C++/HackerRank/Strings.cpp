#include <iostream>
#include <string>

int main() {
	std::string a, b;

	// Enter values for strings (using std::cin instead of std::getline, because of HackerRank compiler error)
	std::cin >> a >> b;

	// Print end result
	std::cout << a.length() << " " << b.length() << std::endl;
	std::cout << a + b << std::endl;
	int temp = a[0];
	a[0] = b[0];
	b[0] = temp;
	std::cout << a << " " << b << std::endl;

	return 0;
}
