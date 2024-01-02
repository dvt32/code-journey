// https://leetcode.com/problems/add-two-promises

type P = Promise<number>

async function addTwoPromises(promise1: P, promise2: P): P {
    let result1 = await promise1;
    let result2 = await promise2;
    return new Promise(resolve => setTimeout(() => resolve(result1 + result2), 0));
};

// Alternative solution
/*
async function addTwoPromises(promise1: P, promise2: P): P {
    return Promise.all([promise1, promise2]).then(function(results) {
        return new Promise(resolve => setTimeout(() => resolve(results[0] + results[1]), 0));
    });
};
*/

/**
 * addTwoPromises(Promise.resolve(2), Promise.resolve(2))
 *   .then(console.log); // 4
 */
