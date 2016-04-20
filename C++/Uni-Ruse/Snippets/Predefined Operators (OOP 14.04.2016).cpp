#include <iostream>

class Numbers {
protected:
	int a, b;
public:
	Numbers() 
	{
		a = 0; 
		b = 0; 
	};
	Numbers(int aValue, int bValue) 
	{
		a = aValue;
		b = bValue;
	}

	void print() {
		std::cout << "a = " << a << ", b = " << b << std::endl;
	}

	// Overload operators
	Numbers operator+(const Numbers& secondOperand) {
		Numbers resultObject;
		resultObject.a = this->a + secondOperand.a;	
		resultObject.b = this->b + secondOperand.b;
		return resultObject;
	}

	Numbers operator-(const Numbers& secondOperand) {
		Numbers resultObject;
		resultObject.a = this->a - secondOperand.a;	
		resultObject.b = this->b - secondOperand.b;
		return resultObject;
	}

	Numbers operator-() {
		Numbers resultObject;
		resultObject.a = -(this->a);
		resultObject.b = -(this->b);
		return resultObject;
	}

	bool operator==(const Numbers& secondOperand) {
		bool objectsAreEqual =
			(this->a == secondOperand.a) &&
			(this->b == secondOperand.b);
		return objectsAreEqual;
	}

	bool operator!=(const Numbers& secondOperand) {
		bool objectsAreNotEqual =
			(this->a != secondOperand.a) ||
			(this->b != secondOperand.b);
		return objectsAreNotEqual;
	}

	friend std::ostream& operator<<(std::ostream &output, const Numbers& object){
		output << object.a;
		return output;
	}


};

int main() {
	Numbers someObject(5, 6);
	Numbers anotherObject(1, 2);
	//Numbers newObject = -someObject;
	//newObject.print();
	std::cout << someObject;

	return 0;
}
