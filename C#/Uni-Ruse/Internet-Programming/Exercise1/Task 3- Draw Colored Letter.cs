/*
 
3 зад
Напишете програма на C#, която отчита натискането на даден клавиш от клавиатурата. 

Нека след натискането на клавиша, програмата да нарисува буква на позиция 10, 10, с жълт цвят.

Забележка: Използвайте функцията 
Console.ReadKey(), 

Свойствата (променливите): 
Console.CursorTop, 
Console.CursorLeft, 
Console.ForegroundColor 

и класовете ConsoleKey и ConsoleKeyInfo.

*/

using System;

namespace InternetProgramming
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.CursorTop = 10;
            Console.CursorLeft = 10;
            Console.ForegroundColor = ConsoleColor.Yellow;
            Console.ReadKey(false);
            Console.WriteLine();
        }
    }
}
