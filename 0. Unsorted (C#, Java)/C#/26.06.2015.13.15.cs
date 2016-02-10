// dvt32

/*

 * 8. Напишете метод ReadNumber(int start, int end), 
 * който въвежда от конзолата число в диапазона [start…end]. 
 * 
 * В случай на въведено невалидно число или число, което не е в подадения диапазон хвърлете подходящо изключение. 
 * 
 * Използвайки този метод напишете програма, която въвежда 10 числа a1, a2, …, a10, такива, че 1 < a1 < … < a10 < 100.

 */


using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Numerics;
using System.IO;


namespace IntroToCSharp
{
    class MainClass
    {

        public static int ReadNumber(int start, int end)
        {
            Console.Write("number = "); int number = int.Parse(Console.ReadLine());
            if (number < start || number > end) { throw new ArgumentOutOfRangeException(); }
            return number;   
        }

        static void Main()
        {

            int currentNumber = 0;

            for (int i = 0; i < 10; ++i)
            {
                try
                {
                    currentNumber = ReadNumber(1, 100);
                }
                catch (FormatException) { Console.WriteLine("Invalid number."); }
                catch (ArgumentOutOfRangeException) { Console.WriteLine("Number is out of range."); }
            }

        }
    }
}