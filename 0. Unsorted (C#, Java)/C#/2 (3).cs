// dvt32

/* 2. Създайте метод GetMax() 
 * с два целочислени (int) параметъра, 
 * който връща по-голямото от двете числа. 
 * 
 * Напишете програма, която 
 * прочита три цели числа от конзолата 
 * и отпечатва най-голямото от тях, 
 * използвайки метода GetMax().*/


using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication1
{
    class Program
    {
        static int GetMax(int a, int b)
        {
            if (a > b) return a;
            if (a < b) return b;
            return a;
        }

        static void Main(string[] args)
        {
            System.Console.Write("a = "); int a = int.Parse(Console.ReadLine());
            System.Console.Write("b = "); int b = int.Parse(Console.ReadLine());
            System.Console.Write("c = "); int c = int.Parse(Console.ReadLine());

            int largestNumber = GetMax(GetMax(a, b), c);

            System.Console.WriteLine("\n" + "Largest number: {0}", largestNumber);
        }

    }
}
