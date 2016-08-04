// https://www.hackerrank.com/challenges/java-date-and-time

import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Solution {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        
        int month = read.nextInt();
        int day = read.nextInt();
        int year = read.nextInt();
        
        Calendar cal = new GregorianCalendar(year, month - 1, day);
        
        String dayOfWeek = "";
        
        switch (cal.get(Calendar.DAY_OF_WEEK)) {
            case 1: dayOfWeek = "SUNDAY"; break;
            case 2: dayOfWeek = "MONDAY"; break;
            case 3: dayOfWeek = "TUESDAY"; break;
            case 4: dayOfWeek = "WEDNESDAY"; break;
            case 5: dayOfWeek = "THURSDAY"; break;
            case 6: dayOfWeek = "FRIDAY"; break;
            case 7: dayOfWeek = "SATURDAY"; break;
            default: break;
        }
        
        System.out.println(dayOfWeek);
        
        // Close scanner
        read.close();
    }
}
