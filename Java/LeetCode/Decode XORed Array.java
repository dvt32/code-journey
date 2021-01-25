// https://leetcode.com/problems/decode-xored-array/

// https://stackoverflow.com/questions/14279866/what-is-inverse-function-to-xor

class Solution {

    public int[] decode(int[] encoded, int first) {
        int[] arr = new int[encoded.length+1];
        arr[0] = first;
        
        for (int i = 1; i < arr.length; ++i) {
            arr[i] = encoded[i-1] ^ arr[i-1];
        }
        
        return arr;
    }
    
}
