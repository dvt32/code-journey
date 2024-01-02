// https://leetcode.com/problems/add-two-promises

/**
 * @param {Promise} promise1
 * @param {Promise} promise2
 * @return {Promise}
 */
var addTwoPromises = async function(promise1, promise2) {
    let result1 = await promise1;
    let result2 = await promise2;
    return new Promise(resolve => setTimeout(() => resolve(result1 + result2), 0));
};

// Alternative solution
/*
var addTwoPromises = async function(promise1, promise2) {
    return Promise.all([promise1, promise2]).then(function(results) {
        return new Promise(resolve => setTimeout(() => resolve(results[0] + results[1]), 0));
    });
};
*/

/**
 * addTwoPromises(Promise.resolve(2), Promise.resolve(2))
 *   .then(console.log); // 4
 */
