// https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side

class Solution {

    public int[] replaceElements(int[] arr) {
        for (int i = 0; i < arr.length-1; ++i) {
            int maxValue = Integer.MIN_VALUE;
            for (int j = i+1; j < arr.length; ++j) {
                maxValue = Math.max(maxValue, arr[j]);
            }
            arr[i] = maxValue;
        }
        
        arr[arr.length-1] = -1;
        
        return arr;
    }
    
}
