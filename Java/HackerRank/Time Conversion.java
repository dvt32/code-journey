/*

Given a time in AM/PM format, convert it to military (24-hour) time.

Note: 

Midnight is 12:00:00 AM on a 12-hour clock and 00:00:00 on a 24-hour clock. 
Noon is 12:00:00 PM on a 12-hour clock and 12:00:00 on a 24-hour clock.

Input Format

A time in 12-hour clock format (i.e.: hh:mm:ssAM or hh:mm:ssPM), where 01≤hh≤12.

Sample Input

07:05:45PM

Sample Output

19:05:45

Explanation

Convert and print the given time in 24-hour format, where 00 ≤ hh ≤ 23.

 */

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        
        String militaryTime = null;
        
        // Read input
        String inputTime = read.nextLine();
        
        // Extract hour, minutes, seconds, AM/PM from input
        String hh = inputTime.substring(0, 2);
        String mm = inputTime.substring(3, 5);
        String ss = inputTime.substring(6, 8);
        String amOrPM = inputTime.substring(8, 10);
        
        // Close program if input is invalid
        if (Integer.valueOf(hh) < 1 || Integer.valueOf(hh) > 12)
        {
        	read.close();
        	return;
        }
        
        // Convert to military time
        if (amOrPM.equals("AM")) 
        {
        	if (Integer.valueOf(hh) == 12) 
        	{ 
        		hh = "00"; 
        	}
        	militaryTime = hh + ":" + mm + ":" + ss;
        }
        else if (amOrPM.equals("PM"))
        {
        	if (Integer.valueOf(hh) == 12) 
        	{
        		hh = "12";
        	}
        	else 
        	{
        		hh = Integer.toString(Integer.valueOf(hh)+12);
        	}
        	militaryTime = hh + ":" + mm + ":" + ss;
        }
        
        // Print military time
        System.out.println(militaryTime);
    
        
        // Close scanner
        read.close();
    }
}
