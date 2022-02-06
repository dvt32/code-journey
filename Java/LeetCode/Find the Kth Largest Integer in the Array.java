// https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/

import java.math.BigInteger;

class Solution {
    
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return new BigInteger(b).compareTo(new BigInteger(a));
            }
        });
        
        return nums[k-1];
    }
    
    // Alternative
    /*
    public String kthLargestNumber(String[] nums, int k) {
        List<BigInteger> numList = new ArrayList<>();
        
        for (int i = 0; i < nums.length; ++i) {
            numList.add( new BigInteger(nums[i]) );
        }
        
        Collections.sort(numList, Collections.reverseOrder());
        
        return numList.get(k-1).toString();
    }
    */
    
}
