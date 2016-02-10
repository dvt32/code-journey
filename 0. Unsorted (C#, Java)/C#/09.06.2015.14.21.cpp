// dvt32

/* 1. Напишете метод, който 
 * при подадено име 
 * отпечатва в конзолата "Hello, <name>!" (например "Hello, Peter!"). 
 * 
 * Напишете програма, която тества този метод дали работи правилно. */


using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {
            string result = "Hello, " + PrintName() + "!";
            System.Console.WriteLine(result);
        }

        static string PrintName(){
            System.Console.Write("Enter name: "); string name = Console.ReadLine();
            return name;
        }
    }
}
