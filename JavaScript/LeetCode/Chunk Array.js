// https://leetcode.com/problems/chunk-array

/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array}
 */
var chunk = function(arr, size) {
    const chunkedArr = [];

    for (var i = 0; i < arr.length; i += size) {
        const chunk = [];

        for (var j = i; j < i+size && j < arr.length; ++j) {
            chunk.push(arr[j]);
        }

        chunkedArr.push(chunk);
    }

    return chunkedArr;
};
