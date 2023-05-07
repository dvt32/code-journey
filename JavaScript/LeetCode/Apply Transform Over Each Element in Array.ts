// https://leetcode.com/problems/apply-transform-over-each-element-in-array

function map(arr: number[], fn: (n: number, i: number) => number): number[] {
    let returnedArray: number[] = [];

    for (let i = 0; i < arr.length; ++i) {
        returnedArray[i] = fn(arr[i], i);
    }

    return returnedArray;
};
