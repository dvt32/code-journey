// https://leetcode.com/problems/categorize-box-according-to-criteria

class Solution {

    fun categorizeBox(length: Int, width: Int, height: Int, mass: Int): String {
        val volume = length.toLong() * width * height
        val isBulky =
            (length >= 10000 || width >= 10000 || height >= 10000 || mass >= 10000) ||
            (volume >= 1_000_000_000)
        val isHeavy = (mass >= 100)
        
        return when {
            isBulky && isHeavy -> "Both"
            isBulky && !isHeavy -> "Bulky"
            !isBulky && isHeavy -> "Heavy"
            else -> "Neither"
        } 
    }
    
}
