// dvt32

/* 10. Дадена е последователност от цели положителни числа, 
 * записани едно след друго като символен низ, разделени с интервал. 
 * 
 * Да се напише програма, която пресмята сумата им. Пример: "43 68 9 23 318" -> 461. */


using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Numerics;


namespace IntroToCSharp
{
    class MainClass
    {
        static void Main()
        {
            Console.Write("Enter numbers: "); string sequence = Console.ReadLine();

            // Split string
            string[] numbers = sequence.Split(' ');

            // Convert numbers to integers and calculate sum of numbers
            int[] numbersInt = new int[numbers.Length];
            int sum = 0;

            for (int i = 0; i < numbers.Length; ++i)
            {
                numbersInt[i] = Convert.ToInt32(numbers[i]);
                sum += numbersInt[i];
            }

            // Print sum
            Console.WriteLine("sum = {0}", sum);

        }
    }
}