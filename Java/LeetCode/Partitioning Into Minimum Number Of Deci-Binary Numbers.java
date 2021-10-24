// https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/

class Solution {
    
    public int minPartitions(String n) {
        return n.chars()
            .map( c -> Character.getNumericValue((char) c) )
            .max()
            .getAsInt();
    }
    
}
