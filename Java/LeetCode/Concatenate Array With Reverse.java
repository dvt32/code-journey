// https://leetcode.com/problems/concatenate-array-with-reverse

class Solution {
    public int[] concatWithReverse(int[] nums) {
        int[] result = new int[nums.length*2];

        for (int i = 0; i < nums.length; ++i) {
            result[i] = nums[i];
            result[nums.length+i] = nums[nums.length-1-i];
        }

        return result;
    }
}

// Alternative solution
/*
class Solution {
    public int[] concatWithReverse(int[] nums) {
        int[] result = new int[nums.length*2];

        for (
            int i = 0, j = nums.length-1, k = result.length/2; 
            i < nums.length; 
            ++i, --j, ++k
        ) {
            result[i] = nums[i];
            result[k] = nums[j];
        }

        return result;
    }
}
*/
