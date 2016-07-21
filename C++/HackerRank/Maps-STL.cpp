// https://www.hackerrank.com/challenges/cpp-maps

#include <iostream>
#include <map>
#include <string>

int main() {
    std::map<std::string, int> myMap;
    std::map<std::string, int>::iterator it;
    int Q;
    int type;
    std::string X;
    int Y;
    
    std::cin >> Q;
    for (int i = 0; i < Q; ++i) {
        std::cin >> type;
        std::cin >> X;
        it = myMap.find(X);
        switch (type) {
            case 1: 
                std::cin >> Y;
                if (it == myMap.end()) {
                    myMap.insert(std::make_pair(X, Y));
                }
                else {
                    it->second += Y;
                }
                break;
            case 2:
                if (it != myMap.end()) {
                    myMap.erase(X);
                }
                break;
            case 3:
                if (it == myMap.end()) {
                    std::cout << "0" << std::endl;
                }
                else {
                    std::cout << it->second << std::endl;
                }
                break;
            default: 
                break;
        }
    }
   
    return 0;
}
