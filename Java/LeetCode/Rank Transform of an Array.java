// https://leetcode.com/problems/rank-transform-of-an-array/

class Solution {
    
    public int[] arrayRankTransform(int[] arr) {
        int[] arrCopy = arr.clone();
        Arrays.sort(arrCopy);
        Map<Integer, Integer> numberRanks = new HashMap<>();
        
        for (int num : arrCopy) {
            numberRanks.putIfAbsent( num, numberRanks.size()+1 );
        }
        
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = numberRanks.get(arr[i]);
        }
        
        return arr;
    }
    
}
