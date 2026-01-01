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
            let y = (nums[i] > nums[j] ? nums[j].toString() : nums[i].toString());
            
            let matched = false;
            for (let m = 0; m < x.length && !matched; ++m) {
                for (let n = m+1; n < x.length && !matched; ++n) {
                    let xSwapped = x.split('');
                    [xSwapped[m], xSwapped[n]] = [x[n], x[m]];
                    xSwapped = xSwapped.join('');

                    if (parseInt(xSwapped) == parseInt(y)) {
                        count++;
                        matched = true;
                    }
                }
            }
        }
    }

    return count;
};
