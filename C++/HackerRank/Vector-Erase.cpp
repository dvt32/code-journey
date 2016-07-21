// https://www.hackerrank.com/challenges/vector-erase

#include <iostream>
#include <algorithm>
#include <vector>

void printVector(int i) {
    std::cout << i << " ";
}

int main() {
    std::vector<int> myVector;
    int N;
    int number;
    int x;
    int a, b;
    
    std::cin >> N;
    for (int i = 0; i < N; ++i) {
        std::cin >> number;
        myVector.push_back(number);
    }
    std::cin >> x;
    myVector.erase(myVector.begin()+x-1);
    std::cin >> a >> b;
    myVector.erase(myVector.begin()+a-1, myVector.begin()+b-1);
    
    std::cout << myVector.size() << std::endl;
    for_each(myVector.begin(), myVector.end(), printVector);
    
    return 0;
}
