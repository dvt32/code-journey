// dvt32

/* 10. Напишете програма, която пресмята и отпечатва n! за всяко n в интервала [1…100]. */


using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Numerics;

namespace IntroToCSharp
{
    class Program
    {
        static BigInteger GetFactorial(int n)
        {
            BigInteger factorial = 1;
            for (int i = 1; i <= n; ++i)
            {
                factorial *= i;
            }
            return factorial;
        }

        static void Main(string[] args)
        {
            System.Console.Write("n = "); int n = int.Parse(Console.ReadLine());
            if (n < 1 || n > 100) return;

            BigInteger result = GetFactorial(n);

            System.Console.WriteLine("!n = {0}", result);

        }
    }
}
