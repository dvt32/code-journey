// http://www.codeabbey.com/index/task_view/triangles

using System;

namespace CSharpCodeProblems
{
    class Solution
    {
        static void Main(string[] args)
        {
            int numberOfTriplets = int.Parse(Console.ReadLine());
            for (int i = 0; i < numberOfTriplets; ++i)
            {
                string[] triplet = Console.ReadLine().Split();
                int a = int.Parse(triplet[0]);
                int b = int.Parse(triplet[1]);
                int c = int.Parse(triplet[2]);

                bool isTriangle = false;
                if (a + b > c &&
                    a + c > b &&
                    b + c > a)
                {
                    isTriangle = true;
                }

                if (isTriangle)
                {
                    Console.Write("1" + " ");
                }
                else
                {
                    Console.Write("0" + " ");
                }
            }
        }
    }
}
