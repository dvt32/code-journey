// https://leetcode.com/problems/count-almost-equal-pairs-i

/**
 * @param {number[]} nums
 * @return {number}
 */
var countPairs = function(nums) {
    let count = 0;

    for (let i = 0; i < nums.length; ++i) {
        for (let j = i+1; j < nums.length; ++j) {
            if (nums[i] == nums[j]) {
                count++;
                continue;
            }

            let x = (nums[i] > nums[j] ? nums[i].toString() : nums[j].toString());
            let y = parseInt((nums[i] > nums[j] ? nums[j].toString() : nums[i].toString()));
            
            let matched = false;
            for (let m = 0; m < x.length && !matched; ++m) {
                for (let n = m+1; n < x.length && !matched; ++n) {
                    let xSwappedArr = x.split('');
                    [xSwappedArr[m], xSwappedArr[n]] = [xSwappedArr[n], xSwappedArr[m]];
                    let xSwapped = parseInt(xSwappedArr.join(''));

                    if (xSwapped == y) {
                        count++;
                        matched = true;
                    }
                }
            }
        }
    }

    return count;
};
