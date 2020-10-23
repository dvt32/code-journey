// https://leetcode.com/problems/decompress-run-length-encoded-list/

class Solution {

    public int[] decompressRLElist(int[] nums) {
        List<Integer> decompressedList = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; ++j) {
                decompressedList.add(nums[i+1]);
            }
        }
        
        return decompressedList.stream().mapToInt(num -> num).toArray();
    }
    
}
