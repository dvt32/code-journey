// dvt32

/* 9.    Write a method that finds the biggest element of an array. Use that method to implement sorting in descending order. */


using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace IntroToCSharp
{
    class Program
    {
        static void getBiggestElementAndSort(int[] arr)
        {
            int max = arr[0];

            // Get biggest element
            for (int i = 0; i < arr.Length; ++i)
            {
                if (arr[i] > max) { max = arr[i]; }
            } System.Console.WriteLine("max = {0}", max);

            // Sort the array in descending order
            Array.Sort<int>(arr);
            Array.Reverse(arr);

            // Print sorted array
            for (int i = 0; i < arr.Length; ++i)
            {
                System.Console.Write("{0} ", arr[i]);
            }


        }

        static void Main(string[] args)
        {
            int[] a = new int[5];

            for (int i = 0; i < a.Length; ++i)
            {
                System.Console.Write("a[{0}]: ", i); a[i] = int.Parse(Console.ReadLine());
            }

            getBiggestElementAndSort(a);
        }
    }
}
