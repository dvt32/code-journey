// https://leetcode.com/problems/filter-elements-from-array

/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
    var newArr = [];
  
    for (var i = 0; i < arr.length; ++i) {
        if (fn(arr[i], i)) {
            newArr.push(arr[i]);
        }
    }
  
    return newArr;
};
