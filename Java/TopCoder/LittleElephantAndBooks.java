// https://community.topcoder.com/stat?c=problem_statement&pm=12112

public class LittleElephantAndBooks {
	public static int getNumber(int[] pages, int number) {
		int pageCount = 0;
		
		// Sort via bubble sort
		int j = 0;
		boolean stillSwapping = true;
		while (stillSwapping) {
			stillSwapping = false;
			j++;
			for (int i = 0; i < pages.length - j; ++i) {
				if (pages[i] > pages[i+1]) {
					int temp = pages[i];
					pages[i] = pages[i+1];
					pages[i+1] = temp;
					stillSwapping = true;
				}
			}
		}
		
		/*
		 * The lazy elephants will always choose the first 'number' books.
		 * Therefore Little Elephant needs to read the first 'number-1' books. 
		 * After that he should skip the book with the number 'number-1' (in order to not become a lazy elephant)
		 * and instead read the book with the number 'number' to be a good little unique elephant.
		 */
		
		// Get second smallest subset sum
		for (int i = 0; i < number-1; ++i) {
			pageCount += pages[i];
		}
		pageCount += pages[number];
		
		return pageCount;
	}
}
