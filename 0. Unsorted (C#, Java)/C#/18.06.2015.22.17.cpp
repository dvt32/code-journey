// dvt32

/* 2. Напишете програма, която генерира и принтира на конзолата 10 случайни числа в интервала [100, 200]. */


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
            Random rand = new Random(5);

            for (int i = 0; i < 10; ++i)
            { 
                int randomNumber = rand.Next(100, 200);
                Console.Write(randomNumber + " ");
            }

        }
    }
}