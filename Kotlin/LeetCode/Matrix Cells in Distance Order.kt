// https://leetcode.com/problems/matrix-cells-in-distance-order

class Solution {
  
    fun allCellsDistOrder(rows: Int, cols: Int, rCenter: Int, cCenter: Int): Array<IntArray> {
        val ans: MutableList<MutableList<Int>> = mutableListOf()

        for (r1 in 0 until rows) {
            for (c1 in 0 until cols) {
                ans.add(mutableListOf(r1, c1, Math.abs(r1 - rCenter) + Math.abs(c1 - cCenter)))
            }
        }

        ans.sortWith(Comparator { t1, t2 ->
            t1[2].compareTo(t2[2])
        })

        ans.forEach {
            it.removeAt(it.size - 1)
        }

        return ans.map { it.toIntArray() }.toTypedArray()
    }
    
}
