// https://leetcode.com/problems/number-of-different-integers-in-a-string/

import java.math.BigInteger;

class Solution {
    
    public int numDifferentIntegers(String word) {
        String[] nums = word.split("\\D+"); // or "[a-z]+"
        Set<BigInteger> uniqueNums = new HashSet<>();
        
        for (String num : nums) {
            if (!num.isEmpty()) {
                uniqueNums.add(new BigInteger(num));
            }
        }

        return uniqueNums.size();
    }

}
