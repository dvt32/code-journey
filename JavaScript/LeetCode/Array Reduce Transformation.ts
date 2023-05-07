// https://leetcode.com/problems/array-reduce-transformation

type Fn = (accum: number, curr: number) => number

function reduce(nums: number[], fn: Fn, init: number): number {
    if (nums.length == 0) {
        return init;
    }

    let result: number = fn(init, nums[0])

    for (var i = 1; i < nums.length; ++i) {
        result = fn(result, nums[i]);
    }

    return result;
};
