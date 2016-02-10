// dvt32

/* 
 11. Напишете програма, която решава следните задачи:
- Обръща последователността на цифрите на едно число.
- Пресмята средното аритметично на дадена поредица от числа.
- Решава линейното уравнение a * x + b = 0.

 * Създайте подходящи методи за всяка една от задачите.

 * Напишете програмата така, че на потребителя да му бъде изведено текстово меню, от което да избира коя от задачите да решава.

 * Направете проверка на входните данни:
- Десетичното число трябва да е неотрицателно.
- Редицата не трябва да е празна.
- Коефициентът a не трябва да е 0.
 * 
 */


using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace IntroToCSharp
{
    class Program
    {
        // Reverse digits of number
        static void ReverseDigits()
        {
            // Enter number
            int number;
            System.Console.Write("Enter number: "); number = int.Parse(Console.ReadLine()); if (number < 0) return;

            // Reverse digits
            int reversed = 0;
            while (number != 0)
            {
                reversed = reversed * 10 + number % 10;
                number /= 10;
            }
            
            // Print result
            System.Console.WriteLine("Reversed: {0}", reversed);
        }

        // Get average of numbers
        static void GetAverage()
        {
            // Enter number sequence in array
            System.Console.Write("Enter number of elements: "); int n = int.Parse(Console.ReadLine()); if (n <= 0) return; System.Console.WriteLine();
            int[] sequence = new int[n];

            for (int i = 0; i < sequence.Length; ++i)
            {
                System.Console.Write("Number " + i + ": "); sequence[i] = int.Parse(Console.ReadLine());
            }

            // Calculate average sum
            int sum = 0;
            for (int i = 0; i < sequence.Length; ++i)
            {
                sum += sequence[i];
            }
            double avg = (double)sum / (double)sequence.Length;
            
            // Print result
            System.Console.WriteLine("Average = {0}", avg);
        }

        // Solve a*x + b = 0
        static void SolveLinearEquation()
        {
            double a, b, x;

            // Enter 'a' and 'b'
            System.Console.Write("a = "); a = double.Parse(Console.ReadLine()); if (a == 0) return;
            System.Console.Write("b = "); b = double.Parse(Console.ReadLine());

            // Calculate 'x'
            x = -b / a;
     
            // Print result
            System.Console.WriteLine("x = {1}", "empty argument", x);
        }

        static void Main(string[] args)
        {
            int menuCode;

            do
            {
                System.Console.WriteLine("\n" + "Menu: ");
                System.Console.WriteLine("- [1] Reverse digits of number");
                System.Console.WriteLine("- [2] Get average of number sequence");
                System.Console.WriteLine("- [3] Solve a linear equation (a*x + b = 0)");

                System.Console.Write("\n" + "Enter operation number or 0 to terminate: "); menuCode = int.Parse(Console.ReadLine());
                System.Console.WriteLine();

                switch (menuCode)
                {
                    case 0: break;
                    case 1: ReverseDigits(); break;
                    case 2: GetAverage(); break;
                    case 3: SolveLinearEquation(); break;
                    default: break;
                }
            } 
            while (menuCode != 0);
       
        }
    }
}
