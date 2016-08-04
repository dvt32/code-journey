// https://www.hackerrank.com/challenges/java-loops-i

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        
        int N = read.nextInt();
        
        for (int i = 1; i <= 10; ++i) {
            System.out.println(N + " x " + i + " = " + N*i);
        }
        
        // Close scanner
        read.close();
    }
}
