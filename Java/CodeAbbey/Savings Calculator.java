// http://www.codeabbey.com/index/task_view/savings-calculator
 
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;
 
class Solution
{
	
	public static int getNumberOfYearsToWait(int S, int R, int P) {
		int numberOfYearsToWait = 0;
		BigDecimal totalMoney = new BigDecimal(S);
		while (totalMoney.compareTo(BigDecimal.valueOf(R)) != 1 /* totalMoney < R */) {
			BigDecimal increase = totalMoney.multiply(new BigDecimal(P * 0.01));
			totalMoney = totalMoney.add(increase).setScale(2, RoundingMode.DOWN);
			numberOfYearsToWait++;
		}
		return numberOfYearsToWait;
	}
	
    public static void main(String[] args)
    {
    	Scanner read = new Scanner(System.in);
        
    	int numberOfTestcases = read.nextInt();
    	
    	for (int i = 0; i < numberOfTestcases; ++i) {
    		int S = read.nextInt();
    		int R = read.nextInt();
    		int P = read.nextInt();
    		int numberOfYearsToWait = getNumberOfYearsToWait(S, R, P);
    		System.out.print(numberOfYearsToWait + " ");
    	}
    	
        // Close scanner
        read.close();
    }
}
