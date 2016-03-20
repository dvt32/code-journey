/* 5. 
 * 
 * Напишете програма, която 
 * - генерира случайно рекламно съобщение за някакъв продукт. 
 * 
 * Съобщенията трябва да се състоят от 
 * - хвалебствена фраза, следвани от 
 * - хвалебствена случка, следвани от 
 * - автор (първо и второ име) и 
 * - град, 
 * които се избират от предварително подготвени списъци. 
 * 
 
 Например, нека имаме следните списъци:
- Хвалебствени фрази: 
	{"Продуктът е отличен.", "Това е страхотен продукт.", "Постоянно ползвам този продукт.", "Това е най-добрият продукт от тази категория."}.	
- Хвалебствени случки: 
	{"Вече се чувствам добре.", "Успях да се променя.", "Той направи чудо.", "Не мога да повярвам, но вече се чувствам страхотно.", "Опитайте и вие. Аз съм много доволна."}.
- Първо име на автор: 
	{"Диана", "Петя", "Стела", "Елена", "Катя"}.
- Второ име на автор: 
	{"Иванова", "Петрова", "Кирова"}.
- Градове: 
	{"София", "Пловдив", "Варна", "Русе", "Бургас"}.
	
Тогава програма би могла да изведе следното случайно-генерирано рекламно съобщение:
Постоянно ползвам този продукт. Опитайте и вие. Аз съм доволна. -– Елена Петрова, Варна

*/

import java.util.Random;

public class MainClass {
	public static void main(String[] args) {
		Random randomGenerator = new Random();
		
		// Store input data in String arrays
		String[] praisePhrase = new String[] {
				"Продуктът е отличен.", 
				"Това е страхотен продукт.", 
				"Постоянно ползвам този продукт.", 
				"Това е най-добрият продукт от тази категория."
		};
		String[] praiseEvent = new String[] {
				"Вече се чувствам добре.", 
				"Успях да се променя.", 
				"Той направи чудо.", 
				"Не мога да повярвам, но вече се чувствам страхотно.", 
				"Опитайте и вие. Аз съм много доволна."
		};
		String[] authorFirstName = new String[] {"Диана", "Петя", "Стела", "Елена", "Катя"};
		String[] authorLastName = new String[] {"Иванова", "Петрова", "Кирова"};
		String[] cityName = new String[] {"София", "Пловдив", "Варна", "Русе", "Бургас"};
		
		// Generate random testimonial
		int randomPraisePhrase = randomGenerator.nextInt(praisePhrase.length);
		int randomPraiseEvent = randomGenerator.nextInt(praiseEvent.length);
		int randomAuthorFirstName = randomGenerator.nextInt(authorFirstName.length);
		int randomAuthorLastName = randomGenerator.nextInt(authorLastName.length);
		int randomCityName = randomGenerator.nextInt(cityName.length);
		
		String randomTestimonial =
				praisePhrase[randomPraisePhrase] + " " + praiseEvent[randomPraiseEvent] +
				" -- " + authorFirstName[randomAuthorFirstName] + " " + authorLastName[randomAuthorLastName] +
				", " + cityName[randomCityName];
		
		// Print end result
		System.out.println(randomTestimonial);
	}
}
