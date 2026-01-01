// https://leetcode.com/problems/count-almost-equal-pairs-i

class Solution {
    
    fun countPairs(nums: IntArray): Int {
        var count = 0;

        for (i in 0 until nums.size) {
            for (j in i+1 until nums.size) {
                if (nums[i] == nums[j]) {
                    count++;
                    continue;
                }

                val x = if (nums[i] > nums[j]) nums[i].toString() else nums[j].toString();
                val y = if (nums[i] > nums[j]) nums[j] else nums[i];
                
                var matched = false;
                for (m in 0 until x.length) {
                    if (matched) break;
                    for (n in m+1 until x.length) {
                        if (matched) break;
                        val xSwapped = StringBuilder(x);
                        xSwapped[m] = x[n];
                        xSwapped[n] = x[m];
                        if (xSwapped.toString().toInt() == y) {
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
