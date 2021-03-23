// https://leetcode.com/problems/binary-gap/

class Solution {

    public int binaryGap(int n) {
        String binary = Integer.toBinaryString(n);
        int maxDistance = 0;
        
        for (int i = 1; i < binary.length(); ++i) {
            int currentDistance = 1;

            while (i < binary.length() && binary.charAt(i) != '1') {
                currentDistance++;
                i++;
            }

            if (i < binary.length()) {
                maxDistance = Math.max(currentDistance, maxDistance);
            }
        }
        
        return maxDistance;
    }
    
}
