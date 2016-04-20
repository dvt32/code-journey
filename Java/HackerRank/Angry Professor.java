// https://www.hackerrank.com/challenges/angry-professor

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        
        int T = read.nextInt();
        if (T < 1 || T > 10) { read.close(); return; }
        for (int i = 0; i < T; ++i) {
            int N = read.nextInt();
            if (N < 1 || N > 1000) { read.close(); return; }
            int K = read.nextInt();
            if (K < 1 || K > N) { read.close(); return; }
            int arrivalTime[] = new int[N];
            int numberOfOnTimeArrivals = 0;
            String classIsCancelled = null;
            for (int j = 0; j < N; ++j) {
                arrivalTime[i] = read.nextInt();
                if (arrivalTime[i] < -100 || arrivalTime[i] > 100) { read.close(); return; }
                if (arrivalTime[i] <= 0) {
                    numberOfOnTimeArrivals++;
                }
            }
            if (numberOfOnTimeArrivals < K) {
                classIsCancelled = "YES";
                System.out.println(classIsCancelled);
            }
            else {
                classIsCancelled = "NO";
                System.out.println(classIsCancelled);
            }
        }
        
        // Close scanner
        read.close();
    }
}
