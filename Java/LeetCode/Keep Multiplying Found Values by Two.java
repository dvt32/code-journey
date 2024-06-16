// https://leetcode.com/problems/keep-multiplying-found-values-by-two/

class Solution {

    public int findFinalValue(int[] nums, int original) {
        int finalValue = original;
        boolean foundOriginal = true;

        while (foundOriginal) {
            foundOriginal = false;
            for (int num : nums) {
                if (num == original) {
                    foundOriginal = true;
                    num *= 2;
                    original = num;
                    finalValue = original;
                    break;
                }
            }
        }
        
        return finalValue;
    }

}
