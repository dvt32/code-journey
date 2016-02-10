// dvt32

/* 8. Напишете програма, която създава 10 обекта от тип Cat, 
 * дава им имена от вида CatN, където N e уникален пореден номер на обекта, 
 * и накрая извиква метода SayMiau() на всеки от тях. 
 * 
 * За реализацията използвайте вече дефинираното пространство Chapter11. */


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
        public string name;

        // Function to test whether the object was successfully created
        public void SayMiau()
        {
            Console.WriteLine("Cat name: {0}", this.name);
        }

    }

}

namespace Chapter11.Examples
{
    class MainClass
    {
        static void Main()
        {
            Cat[] LotsOfCats = new Cat[10];

            for (int i = 0; i < 10; ++i)
            {
                LotsOfCats[i] = new Cat();
                LotsOfCats[i].name = "Cat" + i;
                LotsOfCats[i].SayMiau();
            }
        }
    }
}