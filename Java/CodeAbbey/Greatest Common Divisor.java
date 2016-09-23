// http://www.codeabbey.com/index/task_view/greatest-common-divisor
 
import java.util.Scanner;
 
class Solution
{
	static int getGreatestCommonDivisor(int a, int b) {
		int greatestCommonDivisor = 0;
		while (a != b) {
			if (a > b) {
				a = a - b;
			}
			else {
				b = b - a;
			}
			if (a == b) {
				greatestCommonDivisor = a;
			}
		}
		return greatestCommonDivisor;
	}
	
	static int getLeastCommonMultiple(int a, int b) {
		return a *b / getGreatestCommonDivisor(a, b);
	}
   
    public static void main(String[] args)
    {
        Scanner read = new Scanner(System.in);
        
        int numberOfTestcases = read.nextInt();
        
        for (int i = 0; i < numberOfTestcases; ++i) {
        	int a = read.nextInt();
        	int b = read.nextInt();
        	int gcd = getGreatestCommonDivisor(a, b);
        	int lcm = getLeastCommonMultiple(a, b);
        	System.out.print("(" + gcd + " " + lcm + ") ");
        }
        
        // Close scanner
        read.close();
    }
}
