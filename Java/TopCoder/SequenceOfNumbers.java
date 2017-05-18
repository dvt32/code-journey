// https://community.topcoder.com/stat?c=problem_statement&pm=4659

public class SequenceOfNumbers {
	
	public static void selectionSort(String[] arr) {
		int lastElementIndex = arr.length - 1;
		
		for (int subarrayStartIndex = 0; subarrayStartIndex < lastElementIndex; ++subarrayStartIndex) {
			int minElementIndex = subarrayStartIndex;
			
			for (int i = subarrayStartIndex + 1; i < arr.length; ++i) {
				if ( Integer.parseInt(arr[i]) < Integer.parseInt(arr[minElementIndex]) ) {
					minElementIndex = i;
				}
			}
			
			if (minElementIndex != subarrayStartIndex) {
				String temp = arr[subarrayStartIndex];
				arr[subarrayStartIndex] = arr[minElementIndex];
				arr[minElementIndex] = temp;
			}
		}
	}

	public static String[] rearrange(String[] sequence) {
		selectionSort(sequence);
		
		return sequence;
	}
}
