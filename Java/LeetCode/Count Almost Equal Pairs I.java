// https://leetcode.com/problems/count-almost-equal-pairs-i/

class Solution {
    
    public int countPairs(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; ++i) {
            for (int j = i+1; j < nums.length; ++j) {
                if (nums[i] == nums[j]) {
                    count++;
                    continue;
                }

                String x = String.valueOf(nums[i] > nums[j] ? nums[i] : nums[j]);
                String y = String.valueOf(nums[i] > nums[j] ? nums[j] : nums[i]);
                
                boolean matched = false;
                for (int m = 0; m < x.length() && !matched; ++m) {
                    for (int n = m+1; n < x.length() && !matched; ++n) {
                        StringBuilder xSwapped = new StringBuilder(x);
                        xSwapped.setCharAt(m, x.charAt(n));
                        xSwapped.setCharAt(n, x.charAt(m));
                        if (Integer.parseInt(xSwapped.toString()) == Integer.parseInt(y)) {
                            count++;
                            matched = true;
                        }
                    }
                }
            }
        }

        return count;
    }
    
}
