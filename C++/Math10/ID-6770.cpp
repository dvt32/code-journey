// https://www.math10.com/informatika/viewtopic.php?f=4&t=6770

/*

Да се въведе едномерен масив с не повече от 100 и не по-малко от 10 елемента. 

- Всеки един елемент да се умножи по индекса си. 
- Новополученият масив да се изведе на екрана. 
- Да се намери сумата на елементите на масива.

*/

#include <iostream>

int main()
{
   int numberOfElements;
   double *arr, sumOfElements = 0.0;
   
   // Enter number of elements and exit program if the condition is not met
   std::cout << "Enter number of elements in array: "; std::cin >> numberOfElements;
   if (numberOfElements < 10 || numberOfElements > 100) return 0;

   // Set the array's size, enter a value for each element and then multiply it by its index
   arr = new double[numberOfElements];
   for (int i = 0; i < numberOfElements; ++i) {
      std::cout << "- arr[" << i << "]: "; std::cin >> arr[i];
      arr[i] *= i;
      sumOfElements += arr[i];
   }

   // Print array after it's been modified and the sum of all elements
   for (int i = 0; i < numberOfElements; ++i) {
      std::cout << "- arr[" << i << "]: " << arr[i] << std::endl;
   }

   std::cout << "The sum of all elements is: " << sumOfElements << std::endl;

   delete[] arr;

   return 0;
}
