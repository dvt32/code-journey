// https://leetcode.com/problems/hamming-distance/

class Solution {

    public int hammingDistance(int x, int y) {        
        String xBinary = Integer.toBinaryString(x);
        String yBinary = Integer.toBinaryString(y);
        
        if (xBinary.length() > yBinary.length()) {
            int difference = xBinary.length() - yBinary.length();
            yBinary = "0".repeat(difference) + yBinary;
        }
        else if (yBinary.length() > xBinary.length()) {
            int difference = yBinary.length() - xBinary.length();
            xBinary = "0".repeat(difference) + xBinary;
        }
        
        int result = 0;
        for (int i = 0; i < xBinary.length(); ++i) {
            if (xBinary.charAt(i) != yBinary.charAt(i)) {
                result++;
            }
        }
        
        return result;
    }
    
}
