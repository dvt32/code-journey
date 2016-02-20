// dvt32

/* 3. Напишете програма, която извежда на конзолата кой ден от седмицата е днес. */


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
            DateTime today = DateTime.Today;
            Console.WriteLine(today.DayOfWeek);
        }
    }
}