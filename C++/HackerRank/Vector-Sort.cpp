// https://www.hackerrank.com/challenges/vector-sort

#include <iostream>
#include <algorithm>
#include <vector>

int main() {
    std::vector<int> myVector;
    int N, number;
    
    std::cin >> N;
    for (int i = 0; i < N; ++i) {
        std::cin >> number;
        myVector.push_back(number);
    }
    
    std::sort(myVector.begin(), myVector.end());
    
    for (std::vector<int>::iterator it = myVector.begin(); it != myVector.end(); ++it) {
        std::cout << (*it) << " ";
    }
    
    return 0;
}
