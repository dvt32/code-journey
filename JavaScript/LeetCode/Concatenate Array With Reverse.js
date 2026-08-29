// https://leetcode.com/problems/concatenate-array-with-reverse

/**
 * @param {number[]} nums
 * @return {number[]}
 */
var concatWithReverse = function(nums) {
    let result = Array(nums.length*2);

    for (let i = 0; i < nums.length; ++i) {
        result[i] = nums[i];
        result[nums.length+i] = nums[nums.length-1-i];
    }

    return result;
};
