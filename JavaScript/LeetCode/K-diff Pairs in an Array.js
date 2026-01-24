// https://leetcode.com/problems/k-diff-pairs-in-an-array

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findPairs = function(nums, k) {
    let uniquePairs = new Set();

    for (let i = 0; i < nums.length; ++i) {
        for (let j = i+1; j < nums.length; ++j) {
            if (Math.abs(nums[i]-nums[j]) == k) {
                let a = Math.min(nums[i], nums[j]);
                let b = Math.max(nums[i], nums[j]);
                uniquePairs.add(a + "," + b);
            }
        }
    }

    return uniquePairs.size;
};
