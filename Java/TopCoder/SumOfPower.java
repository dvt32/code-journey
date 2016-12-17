// https://community.topcoder.com/stat?c=problem_statement&pm=13230

import java.util.List;
import java.util.ArrayList;

public class SumOfPower {
	public static int findSum(int[] array) {
	    List<Integer> listArray= new ArrayList<Integer>();
	    for (int i = 0; i < array.length; ++i) {
	   	listArray.add(array[i]);
	    }
	    
	    int sum = 0;
	    for (int i = 0; i < array.length; ++i) {
	    	for (int j = i+1; j <= array.length; ++j) {
	    		List<Integer> subsequence = listArray.subList(i, j);
	    		for (Integer element : subsequence) {
	    			sum += element;
	    		}
		}	    	
	    }
		
	    return sum;
	}
}
