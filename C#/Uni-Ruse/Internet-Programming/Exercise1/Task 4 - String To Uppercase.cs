/*

4 зад
Напишете програма на C #, която прочита 
вашето име от клавиатурата, след което използва функцията 
char.toUpper(), за да го отпечата с големи букви.

*/

using System;

namespace Exercise1
{
    class Solution
    {
        static void Main(string[] args)
        {
            string name = Console.ReadLine();
            name = name.ToUpper();
            Console.WriteLine(name);
        }
    }
}
