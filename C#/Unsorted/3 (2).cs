// dvt32

/* 3. Напишете метод, който 
 * връща английското наименование на последната цифра от дадено число. 
 * 
 * Примери: за числото 512 отпечатва "two"; за числото 1024 – "four". */


using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication1
{
    class Program
    {
        static int GetLastDigit(int number)
        { 
            return number % 10; 
        }

        static string ConvertLastDigitToString(int lastDigit)
        {
            string digitString = "";

            switch (lastDigit)
            {
                case 0: digitString = "zero"; break;
                case 1: digitString = "one"; break;
                case 2: digitString = "two"; break;
                case 3: digitString = "three"; break;
                case 4: digitString = "four"; break;
                case 5: digitString = "five"; break;
                case 6: digitString = "six"; break;
                case 7: digitString = "seven"; break;
                case 8: digitString = "eight"; break;
                case 9: digitString = "nine"; break;
                default: break;
            }

            return digitString;
        }

        static void Main(string[] args)
        {
            System.Console.Write("Number = "); int a = int.Parse(Console.ReadLine());
            System.Console.WriteLine("Last digit = {0}", GetLastDigit(a));
            System.Console.WriteLine("To string = {0}", ConvertLastDigitToString(GetLastDigit(a)));

        }

    }
}
