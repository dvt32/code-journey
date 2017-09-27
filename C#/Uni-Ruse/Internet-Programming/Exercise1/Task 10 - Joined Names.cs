/*

10 зад
Напишете програма на C #, която създава едномерен масив от String. 

Попълнете масива с имената на няколко човека, след което ги отпечатайте в конзолата, като ползвате функцията:  string.Join().

*/

using System;

namespace InternetProgramming
{
    class Program
    {
        static void Main(string[] args)
        {
            String[] names = new String[5];

            for (int i = 0; i < names.Length; ++i)
            {
                names[i] = "Person " + i;
            }

            String joinedNames = String.Join(", ", names);
            Console.WriteLine(joinedNames);
        }
    }
}
