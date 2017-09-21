/*

5 зад
Напишете програма на C#, която прочита 
един символ от клавиатурата, след което използва 
свойствата (променливите), 

char.IsLetter, 
char.IsDigit, 
char.IsPunctuation, 
char.IsLetterOrDigit, 
char.IsLower, 
char.IsUpper 

... и изписва дали даденото свойство е присъщо на прочетения символ.

*/

using System;

namespace Exercise1
{
    class Solution
    {
        static void Main(string[] args)
        {
            char c = Console.ReadKey().KeyChar;
            Console.WriteLine();

            Console.WriteLine("IsLetter: " + Char.IsLetter(c));
            Console.WriteLine("IsDigit: " + Char.IsDigit(c));
            Console.WriteLine("IsPunctuation: " + Char.IsPunctuation(c));
            Console.WriteLine("IsLetterOrDigit: " + Char.IsLetterOrDigit(c));
            Console.WriteLine("IsLower: " + Char.IsLower(c));
            Console.WriteLine("IsUpper: " + Char.IsUpper(c));
        }
    }
}
