// dvt32

/* 7. Дефинирайте свое собствено пространство Chapter11 
 * и поставете в него двата класа Cat и Sequence, 
 * които използвахме в примерите на текущата тема. 
 * 
 * Направете още едно собствено пространство с име Chapter11.Examples и в него направете клас, който извиква класовете Cat и Sequence. */


using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Numerics;

namespace Chapter11
{
    public class Cat 
    {
        protected string color;
        protected string name;

        // Contructor
        public Cat(string colorArg, string nameArg)
        {
            this.color = colorArg;
            this.name = nameArg;
        }

        // Function to test whether the object was successfully created
        public void SayMiau()
        {
            Console.WriteLine("Cat name: {0}, cat color: {1}", this.name, this.color);
        }

    }

    public class Sequence
    {
        protected static int currentNumber = 0;
        public void IncreaseNumber()
        {
            currentNumber++;
            Console.WriteLine("Number: {0}", currentNumber);
        }
    }

}

namespace Chapter11.Examples
{
    class MainClass
    {
        static void Main()
        {
            // Call "Cat" class and see if it works
            Cat Pinky = new Cat("gray", "Pinky");
            Pinky.SayMiau();

            // Call "Sequence" and see if it works
            Sequence zero = new Sequence();
            zero.IncreaseNumber();

        }
    }
}