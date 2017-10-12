/*

4. Зад
Създайте C# приложение, което да прочита файла, създаден в зад 3 
и да пресмята общата застроена площ на всички къщи.

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
            using ( BinaryReader binaryReader = new BinaryReader(File.Open(@"H:\output.bin", FileMode.Open)) ) 
            {
                int totalAreaCovered = 0;
                String[] firstHouseInfo = binaryReader.ReadString().Split(' ');
                String[] secondHouseInfo = binaryReader.ReadString().Split(' ');
                String[] thirdHouseInfo = binaryReader.ReadString().Split(' ');

                totalAreaCovered +=
                    Int32.Parse(firstHouseInfo[2]) +
                    Int32.Parse(secondHouseInfo[2]) +
                    Int32.Parse(thirdHouseInfo[2]);

                Console.WriteLine(totalAreaCovered);
            }
        }
    }
}
