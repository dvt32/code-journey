/*

7 зад
Напишете програма, която генерира 
String парола с 10 произволни букви. 

Използвайте класа StringBuilder 
и метода StringBuilder.Append(), 
за да избегнете създаването на множество обекти от тип String. 

Нека програмта извежда генерираната парола на екрана.

*/

using System;
using System.Text;

namespace InternetProgramming
{
    class Solution
    {
        static void Main(string[] args)
        {
            const String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            StringBuilder password = new StringBuilder();
            Random generator = new Random();

            for (int i = 0; i < 10; ++i)
            {
                int randomLetterIndex = generator.Next(letters.Length);
                char randomLetter = letters[randomLetterIndex];
                password.Append(randomLetter);
            }

            Console.WriteLine(password);
        }
    }
}
