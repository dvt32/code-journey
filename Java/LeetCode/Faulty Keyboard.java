// https://leetcode.com/problems/faulty-keyboard/

class Solution {
    public String finalString(String s) {
        StringBuilder finalStr = new StringBuilder();

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'i') {
                finalStr.reverse();
            } else {
                finalStr.append(s.charAt(i));
            }
        }

        return finalStr.toString();
    }
}
