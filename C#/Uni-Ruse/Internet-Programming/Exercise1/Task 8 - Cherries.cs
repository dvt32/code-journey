/*
 
8 зад
Напишете програма на С#, която генерира прочита 
любимите плодове на даден човек от клавиатурата. 

Нека входа на програмата представлява String, разделен със запетаи. 
Нека след като програмата прочете любимите плодове да определя дали сред тях е черешата. 

Нека ако това е така, програмата да извежда съобщението „Аз също обичам череши”, 
а в противен случай да извежда съобщението ”А аз обичам череши”.

*/

using System;

namespace InternetProgramming
{
    class Program
    {
        static void Main(string[] args)
        {
            String input = Console.ReadLine();

            if (input.IndexOf("cherries", StringComparison.OrdinalIgnoreCase) >= 0)
            {
                Console.WriteLine("I also like cherries!");
            }
            else
            {
                Console.WriteLine("I like cherries!");
            }
        }
    }
}
