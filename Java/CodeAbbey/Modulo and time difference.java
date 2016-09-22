// http://www.codeabbey.com/index/task_view/modulo-and-time-difference
 
import java.util.Scanner;
 
class Solution
{
   
    public static void main(String[] args)
    {
        Scanner read = new Scanner(System.in);
       
        final int ONE_DAY_IN_SECONDS = 86400;
        final int ONE_HOUR_IN_SECONDS = 3600;
        final int ONE_MINUTE_IN_SECONDS = 60;
        
        int numberOfTestcases = read.nextInt();
        
        for (int i = 0; i < numberOfTestcases; ++i) {
        	int day1 = read.nextInt();
        	int hour1 = read.nextInt();
        	int min1 = read.nextInt();
        	int sec1 = read.nextInt();
        	int day2 = read.nextInt();
        	int hour2 = read.nextInt();
        	int min2 = read.nextInt();
        	int sec2 = read.nextInt();
        	
        	int date1_in_seconds = day1 * 86400 + hour1 * 3600 + min1 * 60 + sec1;
        	int date2_in_seconds = day2 * 86400 + hour2 * 3600 + min2 * 60 + sec2;
        	int differenceInSeconds = date2_in_seconds - date1_in_seconds;
        	
        	// Calculate days
        	int days = differenceInSeconds / ONE_DAY_IN_SECONDS;
        	// Calculate hours
        	int hourSeconds = differenceInSeconds % ONE_DAY_IN_SECONDS;
        	int hours = hourSeconds / ONE_HOUR_IN_SECONDS;
        	// Calculate minutes
        	int minuteSeconds = hourSeconds % ONE_HOUR_IN_SECONDS;
        	int minutes = minuteSeconds / ONE_MINUTE_IN_SECONDS;
        	// Calculate seconds
        	int seconds = minuteSeconds % ONE_MINUTE_IN_SECONDS;
        	
        	int[] differenceBetweenDates = new int[] {
        		days,
        		hours,
        		minutes,
        		seconds
        	};
        	
        	System.out.print("(");
        	for (int j = 0; j < differenceBetweenDates.length; ++j) {
        		System.out.print(differenceBetweenDates[j]);
        		if (j < differenceBetweenDates.length - 1) { 
        			System.out.print(" ");
        		}
        	}
        	System.out.print(") ");
        }
        		
        // Close scanner
        read.close();
    }
}
