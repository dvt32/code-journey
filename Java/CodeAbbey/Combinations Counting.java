// http://www.codeabbey.com/index/task_view/combinations-counting

import java.util.Scanner;
import java.math.BigInteger;
 
class Solution
{
	
	public static BigInteger getFactorial(int number) {
		if (number == 0) {
			return BigInteger.ONE;
		}
		BigInteger factorial = BigInteger.ONE;
		for (int i = 2; i <= number; ++i) {
			factorial = factorial.multiply(BigInteger.valueOf(i));
		}
		return factorial;
	}
	
    public static void main(String[] args)
    {
    	Scanner read = new Scanner(System.in);
        
    	int numberOfTestcases = read.nextInt();
    	
    	for (int i = 0; i < numberOfTestcases; ++i) {
    		int N = read.nextInt();
    		int K = read.nextInt();
    		BigInteger numerator = getFactorial(N);
    		BigInteger denominator = getFactorial(K).multiply(getFactorial(N-K));
    		BigInteger C = numerator.divide(denominator);
    		System.out.print(C + " ");
    	}
    	
        // Close scanner
        read.close();
    }
}
