// https://leetcode.com/problems/di-string-match/

class Solution {

    public int[] diStringMatch(String S) {
        int N = S.length();
        int[] A = new int[N+1];
        int left = 0;
        int right = N;
        
        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == 'I') {
                A[i] = left;
                left++;
            }
            else { // 'D'
                A[i] = right;
                right--;
            }
        }
        A[N] = left;
        
        return A;
    }
    
}
