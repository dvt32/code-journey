/* 5. Да се напише програма, която преобразува двоично число в десе-тично. */

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
            Console.Write("myNum: "); string myNum = Console.ReadLine();
            string myNumToDec = Convert.ToString(Convert.ToInt32(myNum, 2), 10);
            Console.WriteLine("myNum to decimal = {0}", myNumToDec);
            Console.ReadKey();
        }
    }
}
