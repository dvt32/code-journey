// // https://www.hackerrank.com/challenges/cpp-lower-bound

#include <iostream>
#include <algorithm>
#include <vector>

int main() {
    std::vector<int> myInts;
    int N, number, Q, Y;
    
    std::cin >> N;
    for (int i = 0; i < N; ++i) {
        std::cin >> number;
        myInts.push_back(number);
    }
    
    std::cin >> Q;
    for (int i = 0; i < Q; ++i) {
        std::cin >> Y;
        std::vector<int>::iterator it = std::lower_bound(myInts.begin(), myInts.end(), Y);
        if (myInts[it-myInts.begin()] == Y) {
            std::cout << "Yes " << (it - myInts.begin() + 1) << std::endl;
        }
        else {
            std::cout << "No " <<  (it - myInts.begin() + 1) << std::endl;
        }                                      
    }
    
    return 0;
}
