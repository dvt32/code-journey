/*

2 Зад
Използвайте цвета зададен в секцията meta info, за да нарисувате изображението със съответния цвят

*/

/*

Създайте C# приложение, което да прочита файла ascii_image_1.ai и 
да отпечатва информацията, записана в него, в конзолата.

Информацията във файла е записана между редовете start и end, 
като на всеки ред са записани x, y координата и символ. 

След прочитането на реда, съответния символ трябва 
да се начертае на посочените координати.

*/

using System;

namespace Exercise3
{
    class Program
    {
        static void Main(string[] args)
        {
            const string FILE_PATH = @"H:\ascii_image_1.ai";
            string[] linesInFile = System.IO.File.ReadAllLines(FILE_PATH);

            // Get & set color
            int i = 0;
            while ( !linesInFile[i].StartsWith("color") )
            {
                i++;
            }
            string colorNumber = linesInFile[i].Substring(linesInFile[i].IndexOf(" ") + 1);
            Console.ForegroundColor = (ConsoleColor) Int32.Parse(colorNumber);

            // Reach "start" line
            i++;
            while ( !linesInFile[i].Equals("start") )
            {
                i++;
            }

            // Print each symbol on specified coordinates until the "end" line is reached
            i++;
            while ( !linesInFile[i].Equals("end") )
            {
                string currentLine = linesInFile[i];
                string[] dataOnLine = currentLine.Split('\t');
                string x = dataOnLine[0];
                string y = dataOnLine[1];
                string symbol = dataOnLine[2];

                Console.CursorLeft = Int32.Parse(x);
                Console.CursorTop = Int32.Parse(y);
                Console.WriteLine(symbol);

                i++;
            }
        }
    }
}
