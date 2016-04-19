// https://www.hackerrank.com/challenges/java-strings-introduction

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        
        String A = read.next();
        String B = read.next(); 
        
        int sumOfLengths = A.length() + B.length();
        String lexiCheck = (A.compareTo(B) > 0) ? "Yes" : "No";
        String capitalization = 
        		A.substring(0,1).toUpperCase() + A.substring(1, A.length()) +
        		" " +
        		B.substring(0,1).toUpperCase() + B.substring(1, B.length());
        
        // Print end result
        System.out.println(sumOfLengths);
        System.out.println(lexiCheck);
        System.out.println(capitalization);
        
        // Close scanner
        read.close();
	}
}
