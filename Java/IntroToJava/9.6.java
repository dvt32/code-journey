// dvt32

/*

9.6. Напишете метод, който 
връща позицията на първия елемент на масив, 
който е по-голям от двата свои съседи едновременно, 
или -1, ако няма такъв елемент.

*/

public class mainClass {
	
	public static int getIndexOfFirstElementLargerThanAdjacentElements(int[] arr) {
		for (int i = 1; i < arr.length-1; ++i) {
			if (arr[i] > arr[i-1] && arr[i] > arr[i+1]) {
					return i;
			}
		}
		return -1;	
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] { 51, 18, 17, 20, 16, 36, 81 };
		
		System.out.print("arr[] = ");
		for (int i = 0; i < arr.length; ++i) {
			System.out.print(arr[i] + " ");
		}
		
		int index = getIndexOfFirstElementLargerThanAdjacentElements(arr);
		System.out.println("\n" + "Result: " + index);	
	}
}
