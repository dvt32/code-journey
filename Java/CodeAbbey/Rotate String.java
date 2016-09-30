// http://www.codeabbey.com/index/task_view/rotate-string
 
// I just had to do it the hard way...

import java.util.Scanner;
 
class Solution
{

	static String rotateString(char[] s, int K) {
		String rotatedString = String.valueOf(s);
		if (K > 0) 
		{
			// Reverse string
	    	for (int j = 0, k = s.length - 1; j < s.length / 2; ++j, --k) {
	    		char temp = s[j];
	    		s[j] = s[k];
	    		s[k] = temp;
	    	}
	    	// Re-reverse first half of string
	    	for (int j = 0, k = (s.length-K-1) - 1; j < (s.length-K-1) / 2; ++j, --k) {
	    		char temp = s[j];
	    		s[j] = s[k];
	    		s[k] = temp;
	    	}
	    	// Re-reverse second half of string
	    	for (int j = s.length-K-1, k = s.length - 1; j < k; ++j, --k) {
	    		char temp = s[j];
	    		s[j] = s[k];
	    		s[k] = temp;
	    	}
	    	// Remove whitespace characters from new string
	    	rotatedString = String.valueOf(s).replaceAll(" ", "");
		}
		else if (K < 0) 
		{
			K = Math.abs(K);
			// Reverse string
	    	for (int j = 0, k = s.length - 1; j < s.length / 2; ++j, --k) {
	    		char temp = s[j];
	    		s[j] = s[k];
	    		s[k] = temp;
	    	}
	    	// Re-reverse first half of string
	    	for (int j = 0, k = K-1; j < K / 2; ++j, --k) {
	    		char temp = s[j];
	    		s[j] = s[k];
	    		s[k] = temp;
	    	}
	    	// Re-reverse second half of string
	    	for (int j = K, k = s.length - 1; j < k; ++j, --k) {
	    		char temp = s[j];
	    		s[j] = s[k];
	    		s[k] = temp;
	    	}
	    	// Remove whitespaces from new string
	    	rotatedString = String.valueOf(s).replaceAll(" ", "");
		}
		
    	return rotatedString;
	}
	
    public static void main(String[] args)
    {
        Scanner read = new Scanner(System.in);
        
        int numberOfTestcases = read.nextInt();
        
        for (int i = 0; i < numberOfTestcases; ++i) {
        	int K = read.nextInt();
        	char[] s = read.nextLine().toCharArray();
        	String s_rotated = rotateString(s, K);
        	System.out.print(s_rotated + " ");
        }
        
        // Close scanner
        read.close();
    }
}
