// dvt32

/*

9.5. Напишете метод, който 
- проверява дали елемент, намиращ се на дадена позиция от масив, 
- e по-голям, или съответно по-малък от двата му съседа.

*/

public class mainClass {
	
	public static int compareToAdjacentElements(int[] arr, int indexOfElement) {
		final int IS_LARGER = 1;
		final int IS_SMALLER = -1;
		final int EQUAL = 0;
		final int ERROR = -2;
		final int i = indexOfElement;
		
		if (arr.length > 1) 
		{
			// Handle first and last element
			if (i == 0) 
			{
				if (arr[i] > arr[i+1]) return IS_LARGER;
				if (arr[i] < arr[i+1]) return IS_SMALLER;
				if (arr[i] == arr[i+1]) return EQUAL;
			}
			if (i == (arr.length-1)) 
			{
				if (arr[i] > arr[i-1]) return IS_LARGER;
				if (arr[i] < arr[i-1]) return IS_SMALLER;
				if (arr[i] == arr[i-1]) return EQUAL;
			}
			// Handle elements with index from 1 to length-1
			if (i >= 1 && i < arr.length-1)
			{
				// Handle IS_LARGER cases
				if (arr[i] > arr[i-1] && arr[i] > arr[i+1]) return IS_LARGER;
				if (arr[i] > arr[i-1] && arr[i] == arr[i+1]) return IS_LARGER;
				if (arr[i] == arr[i-1] && arr[i] > arr[i+1]) return IS_LARGER;
				
				// Handle IS_SMALLER cases
				if (arr[i] < arr[i-1] && arr[i] < arr[i+1]) return IS_SMALLER;
				if (arr[i] < arr[i-1] && arr[i] == arr[i+1]) return IS_SMALLER;
				if (arr[i] == arr[i-1] && arr[i] < arr[i+1]) return IS_SMALLER;
				
				// Handle EQUAL case
				if (arr[i] == arr[i-1] && arr[i] == arr[i+1]) return EQUAL;
			}
		}
		
		return ERROR;	
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] { 51, 18, 17, 20, 16, 36, 81 };
		
		System.out.print("arr[] = ");
		for (int i = 0; i < arr.length; ++i) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.println("\n" + "Compare(2): " + compareToAdjacentElements(arr, 2)); 
		
	}
}
