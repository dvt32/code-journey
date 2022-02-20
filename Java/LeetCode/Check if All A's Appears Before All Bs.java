// https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/

class Solution {

    public boolean checkString(String s) {
        int bFirstIndex = s.indexOf("b");
        int aLastIndex = s.lastIndexOf("a");
        return (bFirstIndex == -1 || aLastIndex == -1) || (bFirstIndex > aLastIndex);
    }
    
}
