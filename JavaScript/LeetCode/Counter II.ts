// https://leetcode.com/problems/counter-ii

type ReturnObj = {
    increment: () => number,
    decrement: () => number,
    reset: () => number,
}

function createCounter(init: number): ReturnObj {
    var initCopy = init;

    function increment() {
        return ++init;
    }

    function decrement() {
        return --init;
    }
    
    function reset() {
        return init = initCopy;
    }

    return { increment, decrement, reset };
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */
