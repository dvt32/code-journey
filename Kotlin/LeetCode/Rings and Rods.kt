// https://leetcode.com/problems/rings-and-rods/

class Solution {

    fun countPoints(rings: String): Int {
        val rodColors = mutableMapOf<Int, MutableSet<Char>>();

        for (i in 0 until rings.length-1 step 2) {
            val ringColor = rings[i]
            val rodNumber = rings[i+1].toInt()

            val currentRodColors = rodColors.getOrDefault(rodNumber, mutableSetOf<Char>());
            currentRodColors.add(ringColor);
            rodColors.put(rodNumber, currentRodColors);
        }

        var result = 0;
        for (currentRodColors in rodColors.values) {
            if (currentRodColors.size == 3) {
                result++;
            }
        }

        return result;
    }

}
