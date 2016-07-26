// https://www.hackerrank.com/challenges/minimum-distances

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Solution {
    
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in); 
        
        int n = read.nextInt();
        
        // Enter element values
        int[] A = new int[n];
        for (int i = 0; i < A.length; ++i) {
            A[i] = read.nextInt();
        }
        
        // Check for matching elements and calculate absolute distance between indices
        TreeSet<Integer> distances = new TreeSet<Integer>();
        for (int i = 0; i < A.length; ++i) {
            for (int j = 0; j < A.length; ++j) {
                if (A[i] == A[j] && i != j) {
                    int currentDistance = Math.abs(i-j);
                    distances.add(currentDistance);
                }
            }
        }
        
        // Print end result
        if (distances.isEmpty()) {
            System.out.println("-1");
        }
        else {
            System.out.println(distances.first());
        }
        
        // Close scanner
        read.close();     
    }
}
