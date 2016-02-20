// dvt32

/*

 2. Напишете програма, която 
 * прочита символен низ, 
 * обръща го отзад напред 
 * и го принтира на конзолата. 
 * 
 * Например: "introduction" -> "noitcudortni".

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
            StringBuilder textReversed = new StringBuilder();

            // Enter text
            Console.Write("Enter string: "); string text = Console.ReadLine();

            // Reverse text
            for (int i = text.Length - 1; i >= 0; i--)
            {
                textReversed.Append(text[i]);
            }

            // Print reversed text
            Console.WriteLine("Reversed string: {0}", textReversed.ToString());

        }
    }
}