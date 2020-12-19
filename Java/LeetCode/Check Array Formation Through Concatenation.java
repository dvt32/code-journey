// https://leetcode.com/problems/check-array-formation-through-concatenation/

class Solution {
    
    public boolean canFormArray(int[] arr, int[][] pieces) {
        StringBuilder arrNums = new StringBuilder();
        for (int num : arr) {
            arrNums.append(num).append(" ");
        }
        
        for (int[] piece : pieces) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < piece.length; ++i) {
                result.append(piece[i]).append(" ");
            }
 
            if ( !arrNums.toString().contains( result.toString() ) ) {
                return false;
            }
        }
        
        return true;
    }
    
}
