// https://leetcode.com/problems/add-binary/

class Solution {

    fun addBinary(a: String, b: String) =
        BigInteger(a, 2).add(BigInteger(b, 2)).toString(2)
        
}
