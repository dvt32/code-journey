// https://leetcode.com/problems/check-if-numbers-are-ascending-in-a-sentence/

class Solution {

    public boolean areNumbersAscending(String s) {
        String[] tokens = s.split(" ");
        int previousNum = 0;
        
        for (String token : tokens) {
            try {
                Integer num = Integer.parseInt(token);
                if (num <= previousNum) {
                    return false;
                }
                previousNum = num;
            }
            catch (NumberFormatException e) {}
        }
        
        return true;
    }
    
    // Alternative worse solution
    /*
    public boolean areNumbersAscending(String s) {
        String[] tokens = s.split(" ");
        List<Integer> nums = new ArrayList<>();
        Set<Integer> sortedNums = new TreeSet<>();
        
        for (String token : tokens) {
            try {
                Integer num = Integer.parseInt(token);
                nums.add(num);
                sortedNums.add(num);
            }
            catch (NumberFormatException e) {}
        }
        
        return (nums.size() == sortedNums.size() && new ArrayList<>(sortedNums).equals(nums));
    }
    */
    
}
