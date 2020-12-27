// https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/

class Solution {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] answer = new int[queries.length];
        
        for (int i = 0; i < queries.length; ++i) {
            for (String W : words) {
                if ( f(queries[i]) < f(W) ) {
                    answer[i]++;
                }
            }
        }
        
        return answer;
    }
    
    public int f(String s) {
        char smallestChar = s.charAt(0);
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) < smallestChar) {
                smallestChar = s.charAt(i);
            }
        }
        
        int smallestCharFrequencies = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == smallestChar) {
                smallestCharFrequencies++;
            }
        }
        
        return smallestCharFrequencies;
    }
    
}
