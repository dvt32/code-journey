// https://leetcode.com/problems/reverse-degree-of-a-string/

class Solution {
  
    public int reverseDegree(String s) {
        int reverseDegree = 0;

        for (int i = 0; i < s.length(); ++i) {
            reverseDegree += (27 - (s.charAt(i) - 'a' + 1)) * (i+1);
        }

        return reverseDegree;
    }
  
}
