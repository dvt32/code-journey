// dvt32

/* 11. Напишете програма, която 
 * генерира случайно рекламно съобщение за някакъв продукт. 
 * 
 * Съобщенията трябва да се състоят от 
 * хвалебствена фраза, следвани от хвалебствена случка, следвани от автор (първо и второ име) и град, 
 * които се избират от предварително подготвени списъци. Например, нека имаме следните списъци:
 * 
- Хвалебствени фрази: {"Продуктът е отличен.", "Това е страхотен продукт.", "Постоянно ползвам този продукт.", "Това е най-добрият продукт от тази категория."}.
- Хвалебствени случки: {"Вече се чувствам добре.", "Успях да се променя.", "Той направи чудо.", "Не мога да повярвам, но вече се чувствам страхотно.", "Опитайте и вие. Аз съм много доволна."}.
- Първо име на автор: {"Диана", "Петя", "Стела", "Елена", "Катя"}.
- Второ име на автор: {"Иванова", "Петрова", "Кирова"}.
- Градове: {"София", "Пловдив", "Варна", "Русе", "Бургас"}.

Тогава програма би могла да изведе следното случайно-генерирано рекламно съобщение:
Постоянно ползвам този продукт. Опитайте и вие. Аз съм доволна. -– Елена Петрова, Варна

 */


using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Numerics;


namespace IntroToCSharp
{
    class MainClass
    {
        static void Main()
        {
            // Change code page to display the Bulgarian text
            Console.OutputEncoding = System.Text.Encoding.Unicode;

            // Database of strings
            string[] praisePhrases = { "Продуктът е отличен.", 
                                         "Това е страхотен продукт.", 
                                         "Постоянно ползвам този продукт.", 
                                         "Това е най-добрият продукт от тази категория." };
            string[] praiseEvents = {"Вече се чувствам добре.", 
                                        "Успях да се променя.", 
                                        "Той направи чудо.", 
                                        "Не мога да повярвам, но вече се чувствам страхотно.", 
                                        "Опитайте и вие. Аз съм много доволна."};
            string[] firstNames = { "Диана", "Петя", "Стела", "Елена", "Катя" };
            string[] lastNames = { "Иванова", "Петрова", "Кирова" };
            string[] cities = { "София", "Пловдив", "Варна", "Русе", "Бургас" };

            // Use randomizer
            Random random = new Random();
            string randomPraisePhrase = praisePhrases[random.Next(praisePhrases.Length)];
            string randomPraiseEvent = praiseEvents[random.Next(praiseEvents.Length)];
            string randomFirstName = firstNames[random.Next(firstNames.Length)];
            string randomLastName = lastNames[random.Next(lastNames.Length)];
            string randomCity = cities[random.Next(cities.Length)];


            // Print result
            Console.WriteLine("\"" + randomPraisePhrase + " "
                                + randomPraiseEvent + "\"" + " -- "
                                + randomFirstName + " " + randomLastName + ", "
                                + randomCity);

        }
    }
}