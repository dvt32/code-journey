/*

2. Бързо умножение
Алгоритъм:
1)	направете таблица с три колони, в първата напишете първото число, а във втората - второто. Третата остава празна за сега.
2)	започнете да делите първото число на две, като взимате само цялата част. Записвайте резултатите последователно в първата колонка докато не стигнете до 1. 
3)	умножете второто число по две, толкова пъти колкото сте разделили първото и отново записвайте резултатите последователно. 
4)	в третата колонка прехвърлете всички резултати от втората колонка, които стоят до нечетно число от първата колона. 
5)	съберете числата от третата колона и това е вашия резултат. 

*/

// Optimization ideas:
// - use less data structures
// - use less loops etc.

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Solution {
	
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int firstNumber = read.nextInt();
		int secondNumber = read.nextInt();
		
		/*
			1) направете таблица с три колони, 
			в първата напишете първото число, а 
			във втората - второто. 
			Третата остава празна за сега. 
		*/
		List<Integer> firstColumn = new ArrayList<Integer>();
		List<Integer> secondColumn = new ArrayList<Integer>();
		List<Integer> thirdColumn = new ArrayList<Integer>();
		firstColumn.add(firstNumber);
		secondColumn.add(secondNumber);
		
		/*
			2) започнете да делите първото число на две, 
			като взимате само цялата част. 
			Записвайте резултатите последователно в първата колонка 
			докато не стигнете до 1. 
		*/
		while (firstNumber != 1) {
			firstNumber /= 2;
			firstColumn.add(firstNumber);
		}
		
		/*
			 3)	умножете второто число по две, 
			 толкова пъти колкото сте разделили първото и 
			 отново записвайте резултатите последователно. 
		*/
		int numberOfDivisions = firstColumn.size()-1;
		for (int i = 0; i < numberOfDivisions; ++i) {
			secondNumber *= 2;
			secondColumn.add(secondNumber);
		}
		
		/*
			 4)	в третата колонка 
			 прехвърлете всички резултати от втората колонка, 
			 които стоят до нечетно число от първата колона. 
		*/
		for (int i = 0; i < secondColumn.size(); ++i) {
			if (firstColumn.get(i) % 2 != 0) {
				int currentElementFromSecondColumn = secondColumn.get(i);
				thirdColumn.add(currentElementFromSecondColumn);
			}
		}
		
		// 5)	съберете числата от третата колона и това е вашият резултат.
		int result = 0;
		for (int i = 0; i < thirdColumn.size(); ++i) {
			int currentElementFromThirdColumn = thirdColumn.get(i);
			result += currentElementFromThirdColumn;
		}
		
		// Print end result
		System.out.println(result);
		
		// Close scanner
		read.close();
	}
}
