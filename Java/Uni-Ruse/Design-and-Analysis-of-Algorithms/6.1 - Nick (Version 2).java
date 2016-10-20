// dvt32 - 20.10.2016

/*
1.	Потребителско име (никнейм)
Ето, че и сегашният никнейм: 5|<%P3_FFFE|\|G@+/\–lIgLic4hkayyy!!1! на скайп- фенката Лигличкaтъ взе да й омръзва. Не може и да я вините – само от 15 минути е в Skype-а, а някои от приятелите й вече я разпознаха (което всъщност трябваше да се очаква). Затова е нетърпелива да последва днешната мода – да си избере за никнейм някаква дълбока мисъл, изписана с редуващи се главни и малки букви: НеЩо–тАкОвА–СеЩаШ–Ли–сЕ–КоЛкО–Е–ЯкО. А това е изключително затормозяващо! Трябва постоянно да внимаваш и да помниш четността на поредния номер на текущата буква заради правилото:
•	ако на нечетна позиция в ника има буква –  тя непременно трябва да е главна;
•	ако на четна позиция в ника има буква – тя непременно трябва да е малка;
•	цифрите и другите знаци, които не са букви –  не се променят, независимо на каква позиция са; 
•	интервали и букви на кирилица в ника няма да има, нито пък точки, с изключение на една за край на цялото това велико умотворение.
Напишете програма nick, която получава като вход мъдрата мисъл, която нашата героиня си е избрала за скайп-име и извежда същия текст, променен до неузнаваемост, както повелява скайп-модата. Позициите в текста броим от 1, започвайки от най-левия знак.

 */

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String input = read.nextLine();
		StringBuilder output = new StringBuilder();
		
		for (int i = 0; i < input.length(); ++i) {
			char currentChar = input.charAt(i);
			boolean currentCharIsLetter = Character.isLetter(currentChar);
			switch ((i+1) % 2) {
				case 0:
					if (currentCharIsLetter) {
						output.append(Character.toLowerCase(currentChar));
					}
					else {
						output.append(currentChar);
					}
					break;
				case 1: 
					if (currentCharIsLetter) {
						output.append(Character.toUpperCase(currentChar));
					}
					else {
						output.append(currentChar);
					}
					break;
				default: break;
			}
		}
		
		// Print end result
		System.out.println(output);
		
		// Close scanner
		read.close();
	}
}
