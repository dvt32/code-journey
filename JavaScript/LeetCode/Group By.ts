// https://leetcode.com/problems/group-by

declare global {
    interface Array<T> {
        groupBy(fn: (item: T) => string): Record<string, T[]>
    }
}

Array.prototype.groupBy = function(fn) {
    var result = {};

    for (let el of this) {
        var key = fn(el)
        if (!(key in result)) {
            result[key] = [];
        }
        result[key].push(el);
    }

    return result;
}

/**
 * [1,2,3].groupBy(String) // {"1":[1],"2":[2],"3":[3]}
 */
