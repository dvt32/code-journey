// https://www.hackerrank.com/challenges/java-list

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        
        List<Integer> L = new ArrayList<Integer>();
        
        // Enter N elements and add them to list
        int N = read.nextInt();
        for (int i = 0; i < N; ++i) {
           L.add(read.nextInt());
        }
        
        // Enter Q queries
        int Q = read.nextInt();
        for (int i = 0; i < Q; ++i) {
            String typeOfQuery = read.next();
            if (typeOfQuery.equals("Insert")) {
                int x = read.nextInt();
                int y = read.nextInt();
                L.add(x, y);
            }
            else if (typeOfQuery.equals("Delete")) {
                int z = read.nextInt();
                L.remove(z);
            }   
        }
        
        // Print end result
        for (Integer el : L) {
            System.out.print(el + " ");
        }
        
        // Close scanner
        read.close();
    }
}
