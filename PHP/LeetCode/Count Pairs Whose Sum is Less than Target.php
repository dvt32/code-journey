// https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/

class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer
     */
    function countPairs($nums, $target) {
        $pairCount = 0;

        for ($i = 0; $i < count($nums)-1; ++$i) {
            for ($j = $i+1; $j < count($nums); ++$j) {
                if ($nums[$i] + $nums[$j] < $target) {
                    $pairCount++;
                }
            }
        }
        
        return $pairCount;
    }

}
