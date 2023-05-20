// https://leetcode.com/problems/counter-ii/

/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
    var initCopy = init;

    this.increment = function() {
        return ++init;
    }

    this.decrement = function() {
        return --init;
    }
    
    this.reset = function() {
        return init = initCopy;
    }
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */
