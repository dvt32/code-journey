// https://leetcode.com/problems/chunk-array

type JSONValue = null | boolean | number | string | JSONValue[] | { [key: string]: JSONValue };
type Obj = Record<string, JSONValue> | Array<JSONValue>;

function chunk(arr: Obj[], size: number): Obj[][] {
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
