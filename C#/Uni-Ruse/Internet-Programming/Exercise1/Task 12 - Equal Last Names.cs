/*
 
12. зад
Напишете програма на C #, Прочита имената на двама човека, след което сравнява последните им имена и казва дали те са еднакви или не.

*/

using System;

namespace InternetProgramming
{
    class Program
    {
        static void Main(string[] args)
        {
            String[] firstPersonNames = Console.ReadLine().Split(' ');
            String[] secondPersonNames = Console.ReadLine().Split(' ');
            Console.WriteLine(
                firstPersonNames[firstPersonNames.Length - 1]
                .Equals( secondPersonNames[secondPersonNames.Length-1] )
            );
        }
    }
}
