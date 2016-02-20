/* 4. Да се напише програма, която преобразува десетично число в двоично. */

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace My_CSharp_Project
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("myNum: "); int myNum = int.Parse(Console.ReadLine());
            string myNumToBin = Convert.ToString(myNum, 2);
            Console.WriteLine("myNum to binary = {0}", myNumToBin);
            Console.ReadKey();
        }
    }
}
