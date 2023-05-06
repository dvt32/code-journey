// https://leetcode.com/problems/filter-elements-from-array

function filter(arr: number[], fn: (n: number, i: number) => any): number[] {
    let newArr: number[] = [];

    for (var i = 0; i < arr.length; ++i) {
        if (fn(arr[i], i)) {
            newArr.push(arr[i]);
        }
    }

    return newArr;
};
