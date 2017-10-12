/*

2. Зад
Създайте C# приложение, което да копира файла, създаден в задача 1, като при копирането малките букви се преобразуват в големи, а големите в малки.

*/

using System;
using System.IO;

namespace Exercise3
{
    class Program
    {
        static void Main(string[] args)
        {
            using (StreamReader reader = new StreamReader(@"H:\input.txt"))
            using (StreamWriter writer = new StreamWriter(@"H:\output.txt", append: false))
            {
                writer.WriteLine(reader.ReadLine());
                writer.WriteLine(reader.ReadLine());
                writer.WriteLine(reader.ReadLine());
            }
        }
    }
}
