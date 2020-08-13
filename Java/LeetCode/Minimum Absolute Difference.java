// https://leetcode.com/problems/minimum-absolute-difference/

class Solution {
    
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        
        int minDifference = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length-1; ++i) {
            int currentDifference = arr[i+1] - arr[i]; // no need for Math.abs() because array is sorted
            minDifference = Math.min(currentDifference, minDifference);
        }
        
        List< List<Integer> > result = new ArrayList<>();
        for (int i = 0; i < arr.length-1; ++i) {
            int currentDifference = arr[i+1] - arr[i];
            if (currentDifference == minDifference) {
                result.add( Arrays.asList(arr[i], arr[i+1]) );
            }
        }
        
        return result;
    }
    
}
