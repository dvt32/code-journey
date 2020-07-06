// https://leetcode.com/problems/height-checker/

class Solution {
    
    public int heightChecker(int[] heights) {
        int[] sortedHeights = heights.clone();
        
        Arrays.sort(sortedHeights);
        
        int result = 0;
        for (int i = 0; i < heights.length; ++i) {
            if (heights[i] != sortedHeights[i]) {
                result++;
            }
        }
        
        return result;
    }
    
}
