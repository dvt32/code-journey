// https://www.hackerrank.com/challenges/cpp-sets

#include <iostream>
#include <set>

int main() {
    std::set<int> mySet;
    std::set<int>::iterator it;
    int Q;
    int y;
    int x;
    
    std::cin >> Q;
    for (int i = 0; i < Q; ++i) {
        std::cin >> y;
        std::cin >> x;
        switch (y) {
            case 1: 
                mySet.insert(x);
                break;
            case 2: 
                mySet.erase(x);
                break;
            case 3:
                it = mySet.find(x);
                if (it == mySet.end()) {
                    std::cout << "No" << std::endl;
                }
                else {
                    std::cout << "Yes" << std::endl;
                }
                break;
            default: 
                break;
        }
    }
    
    return 0;
}
