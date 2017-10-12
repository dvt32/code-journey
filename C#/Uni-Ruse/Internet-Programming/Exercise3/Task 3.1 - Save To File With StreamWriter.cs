/*

1. Зад
Създайте C# приложение, което да прочита имената на няколко човека от конзолата и да ги записва във файл с помощта на StreamWriter.

*/

using System;
using System.IO;

namespace Exercise3
{
    class Program
    {
        static void Main(string[] args)
        {
            using (StreamWriter writer = new StreamWriter(@"H:\output.txt"))
            {
                writer.WriteLine( Console.ReadLine() );
                writer.WriteLine( Console.ReadLine() );
                writer.WriteLine( Console.ReadLine() );
            }
        }
    }
}
