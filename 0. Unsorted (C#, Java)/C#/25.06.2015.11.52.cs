// dvt32

/*
7. Напишете програма, която 
 * прочита от конзолата цяло положително число 
 * и отпечатва на конзолата корен квадратен от това число. 
 * 
 * Ако числото е отрицателно или невалидно, да се изпише "Invalid Number" на конзолата. 
 * Във всички случаи да се принтира на конзолата "Good Bye".

 */


using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Numerics;
using System.IO;


namespace IntroToCSharp
{
    class MainClass
    {
        static void Main()
        {
            try
            {
                Console.Write("a = "); uint a = uint.Parse(Console.ReadLine());
                Console.WriteLine(Math.Sqrt(a));
            }
            catch (OverflowException)
            {
                Console.WriteLine("Number smaller than 0.");
            }
            catch (FormatException)
            {
                Console.WriteLine("Invalid number.");
            } 
            finally
            {
                Console.WriteLine("Good Bye");
            }

        }
    }
}