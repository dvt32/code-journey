#include <iostream>
#include <list>
#include <vector>

class Figure {
public:
	virtual void drawStuff() = 0;
};

class Circle : public Figure {
public:
	void drawStuff() {
		std::cout << "Drawing circle." << std::endl;
	}
};


int main()
{
	std::vector<Figure*> myVector;
	// Figure *circle = new Circle();
	myVector.push_back(new Circle());

	for (std::vector<Figure*>::iterator it = myVector.begin(); it != myVector.end(); ++it) 
	{
		(*it)->drawStuff();
	}

	return 0;
}
