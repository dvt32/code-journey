// https://leetcode.com/problems/third-maximum-number/

class Solution {

    public int thirdMax(int[] nums) {
        TreeSet<Integer> numbers = new TreeSet<>();
        
        for (int num : nums) {
            numbers.add(num);
        }
        
        if (numbers.size() >= 3) {
            numbers.pollLast();
            numbers.pollLast();
        }
        
        return numbers.last();
    }
    
}
