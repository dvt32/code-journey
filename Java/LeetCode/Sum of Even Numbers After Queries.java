// https://leetcode.com/problems/sum-of-even-numbers-after-queries/

class Solution {
    
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int evenNumbersSum = 0;
        for (int number : A) {
            if (number % 2 == 0) {
                evenNumbersSum += number;
            }
        }
        
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            int val = queries[i][0];
            int index = queries[i][1];
            
            if (A[index] % 2 == 0) {
                evenNumbersSum -= A[index];
            }
            
            A[index] += val;
            
            if (A[index] % 2 == 0) {
                evenNumbersSum += A[index];
            }

            answer[i] = evenNumbersSum;
        }
        
        return answer;
    }
    
}
