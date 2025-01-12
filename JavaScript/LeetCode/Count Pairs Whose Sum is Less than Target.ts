// https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/

function countPairs(nums: number[], target: number): number {
    var pairCount = 0;

    for (let i = 0; i < nums.length-1; ++i) {
        for (let j = i+1; j < nums.length; ++j) {
            if (nums[i] + nums[j] < target) {
                pairCount++;
            }
        }
    }

    return pairCount;
};
