/* 15. Опитайте да сумирате 50 000 000 пъти числото 0.000001. 
 * Използвайте цикъл и събиране (не директно умножение). 
 * Опитайте с типовете float и double и след това с decimal. Забелязвате ли разликата в резултатите и в скоростта? */

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
            // float
            float myFloat = 0.000001f;

            for (int i = 0; i < 50000000; ++i) 
            {
                myFloat += 0.000001f;
            }
            Console.WriteLine("myFloat = {0}", myFloat);

            // double
            double myDouble = 0.000001d;

            for (int i = 0; i < 50000000; ++i)
            {
                myDouble += 0.000001d;
            }
            Console.WriteLine("myDouble = {0}", myDouble);

            // decimal
            decimal myDecimal = 0.000001m;

            for (int i = 0; i < 50000000; ++i) 
            {
                myDecimal += 0.000001m;
            }
            Console.WriteLine("myDecimal = {0}", myDecimal);
        }
    }
}
