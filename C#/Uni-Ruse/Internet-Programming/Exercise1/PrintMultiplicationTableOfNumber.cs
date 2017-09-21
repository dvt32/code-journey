/*
1 Зад
Напишете програма на C #, която прочита число като вход и 
отпечатва таблицата за умножение (от 0 до 10) на това число.

Забележка: 

Използвайте функциите Console.ReadLine(), int.Parse() или  Convert.ToInt32(), Console.WriteLine()
*/

using System;

namespace Exercise1
{
    class PrintMultiplicationTableOfNumber
    {
        static void Main(string[] args)
        {
            int n = Int32.Parse( Console.ReadLine() );

            for (int i = 0; i <= 10; ++i)
            {
                Console.WriteLine(n + " * " + i + " = " + (n * i));
            }
        }
    }
}
