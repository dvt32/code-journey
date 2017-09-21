/*

6 зад
Напишете програма, която прочита 4 имена от клавиатурата, 
и ги натрупва в едина променлива от тип String, 
разделени със запетая. 

Използвайте класа StringBuilder и метода 
StringBuilder.Append(), за да избегнете 
създаването на множество обекти от тип String. 

След като съедините всички въведени имена ги изведете на екрана.

*/

using System;
using System.Text;

namespace InternetProgramming
{
    class Solution
    {
        static void Main(string[] args)
        {
            String a = Console.ReadLine();
            String b = Console.ReadLine();
            String c = Console.ReadLine();
            String d = Console.ReadLine();

            StringBuilder names = new StringBuilder();
            names.Append(a + ", ").Append(b + ", ").Append(c + ", ").Append(d);

            Console.WriteLine(names);
        }
    }
}
