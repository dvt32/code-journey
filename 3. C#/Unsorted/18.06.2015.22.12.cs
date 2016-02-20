// dvt32

/* 1. Напишете програма, която прочита от конзолата година и проверява дали е високосна. */


using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Numerics;

namespace myNamespace
{
    class myClass
    {
        static void Main()
        {
            Console.Write("Enter year: "); int year = int.Parse(Console.ReadLine());
            Console.WriteLine("Is it a leap year? {0}", DateTime.IsLeapYear(year));

        }
    }
}