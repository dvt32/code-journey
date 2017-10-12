/*

3. Зад
Създайте клас за обекта House. 

В него добавете няколко свойства (адрес, застроена площ и бр. етажи) 
и параметризиран конструктор, който да инициализира свойствата.

В метода main() добавете код, който 
да прочита информацията за няколко къщи (2-3), 
след което я записва във файл с помощта на BinaryWriter.

*/

using System;
using System.IO;

namespace Exercise3
{
    class House
    {
        public String Address { get; set; }
        public int NumberOfFloors { get; set; }
        public int AreaCovered { get; set; }

        public House() {}

        public House(String address, int areaCovered, int numberOfFloors)
        {
            Address = address;
            AreaCovered = areaCovered;
            NumberOfFloors = numberOfFloors;
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            House a = new House("Address 1", 1, 1);
            House b = new House("Address 2", 2, 2);
            House c = new House("Address 3", 3, 3);

            using ( BinaryWriter binaryWriter = new BinaryWriter(File.Open(@"H:\output.bin", FileMode.Create)) ) 
            {
                binaryWriter.Write( a.Address + " " + a.AreaCovered + " " + a.NumberOfFloors );
                binaryWriter.Write( b.Address + " " + b.AreaCovered + " " + b.NumberOfFloors );
                binaryWriter.Write( c.Address + " " + c.AreaCovered + " " + c.NumberOfFloors );
            }
        }
    }
}
