/*

2.зад

Напишете програма на C #, която прочита две числа от клавиатурата 
и изписва „Да”, ако и двете числа са четни или нечетни 
и “Не”, ако едното число е четно, а другото нечетно.

*/

using System;

namespace Exercise1
{
    class OddAndEvenNumberCheck
    {
        static void Main(string[] args)
        {
            int a = int.Parse(Console.ReadLine());
            int b = int.Parse(Console.ReadLine());

            bool bothEven = ((a % 2 == 0) && (b % 2 == 0));
            bool bothUneven = ((a % 2 == 1) && (b % 2 == 1));

            if (bothEven || bothUneven)
            {
                Console.WriteLine("Да");
            }
            else
            {
                Console.WriteLine("Не");
            }
        }
    }
}
