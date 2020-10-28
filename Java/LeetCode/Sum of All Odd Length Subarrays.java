// https://leetcode.com/problems/sum-of-all-odd-length-subarrays/

class Solution {
    
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        
        for (int subArrayLength = 1; subArrayLength <= arr.length; subArrayLength += 2) {
            for (int i = 0; i < arr.length; ++i) {
                int subArrayStartIndex = i;
                int subArrayEndIndex = (i + subArrayLength - 1);
                if (subArrayEndIndex < arr.length) {
                    for (int j = subArrayStartIndex; j <= subArrayEndIndex; ++j) {
                        sum += arr[j];
                    }
                }
            }
        }
        
        return sum;
    }
    
}
