// https://leetcode.com/problems/concatenate-array-with-reverse

function concatWithReverse(nums: number[]): number[] {
    let result = Array(nums.length*2);

    for (let i = 0; i < nums.length; ++i) {
        result[i] = nums[i];
        result[nums.length+i] = nums[nums.length-1-i];
    }

    return result;
};
