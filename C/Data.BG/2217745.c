// http://forums.data.bg/index.php?showtopic=2217745

/*Задание 12: Изброите количеството цели числа в диапазона от 100 до 999 които имат две еднакви цифри.*/

// The solution assumes that numbers with 3 matching digits also count.

#include <stdio.h>

int main() {
        int count = 0;

        for (int currentNumber = 100; currentNumber <= 999; ++currentNumber) {
                char digitsOfNumber[4];
                sprintf(digitsOfNumber, "%d", currentNumber);
                if (digitsOfNumber[0] == digitsOfNumber[1] ||
                    digitsOfNumber[1] == digitsOfNumber[2] ||
                    digitsOfNumber[0] == digitsOfNumber[2])
                {
                        printf("%d \n", currentNumber);
                        count++;
                }
        }

        printf("\n%d \n", count);

        return 0;
}
