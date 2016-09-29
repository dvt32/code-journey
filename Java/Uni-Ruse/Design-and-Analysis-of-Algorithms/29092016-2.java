// PAA Practice 29.09.2016 - dvt32

// 1. GCD Implementation - version 2

public class Solution {
	
	static int getGreatestCommonDivisor(int u, int v) {
		int greatestCommonDivisor = -1;
		
		/* 1. 
		 * 		- НОД(0, v) = v, тъй като 0 дели всичко, а v е най-голямото число, което дели v. 
		 * 		- Aналогично, НОД(u, 0) = u. 
		 * 		- НОД(0, 0) е неопределен.
		*/
		if (u == 0) { 
			greatestCommonDivisor = v;
			return greatestCommonDivisor; 
		}
		else if (v == 0) {
			greatestCommonDivisor = u;
			return greatestCommonDivisor;
		}
		else if (u == 0 && v == 0) {
			return greatestCommonDivisor; // -1
		}
		
		/* 2.
		 * 	- Ако u и v are са четни, НОД(u, v) = 2 * НОД(u/2, v/2), тъй като 2 е общ делител.
		 */
		else if (u % 2 == 0 && v % 2 == 0) {
			greatestCommonDivisor = 2 * getGreatestCommonDivisor(u / 2, v / 2);
		}
		
		/* 3. 
		 * 	Ако u е четно, а v е нечетно, тогава, НОД(u, v) = НОД(u/2, v), тъй като 2 не е общ делител. 
		 * 	Аналогично, ако u е нечетно, а v е четно, НОД(u, v) = НОД(u, v/2). 
		*/
		else if (u % 2 == 0 && v % 2 != 0) {
			greatestCommonDivisor = getGreatestCommonDivisor(u / 2, v);
		}
		else if (u % 2 != 0 && v % 2 == 0) {
			greatestCommonDivisor = getGreatestCommonDivisor(u, v / 2);
		}
		
		/* 4. 
		 * 	Ако u и v са нечетни и u ≥ v, тогава НОД(u, v) = НОД((u−v)/2, v). 
		 * 	Ако и двете са нечетни и u < v, тогава НОД(u, v) = НОД((v-u)/2, u). 
		 */
		else if (u % 2 != 0 && v % 2 != 0 && u >= v) {
			greatestCommonDivisor = getGreatestCommonDivisor((u-v)/2, v);
			return greatestCommonDivisor;
		}
		else if (u % 2 != 0 && v % 2 != 0 && u < v) {
			greatestCommonDivisor = getGreatestCommonDivisor((v-u)/2, u);
			return greatestCommonDivisor;
		}
		
		return greatestCommonDivisor;
	}
	
	public static void main(String[] args) {
		System.out.println(
				getGreatestCommonDivisor(21, 6)
		);
	}
}
