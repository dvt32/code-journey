// https://leetcode.com/problems/n-repeated-element-in-size-2n-array/

class Solution {

    public int repeatedNTimes(int[] A) {
        Set<Integer> uniqueElements = new HashSet<>();
        
        int i = 0;
        while (i < A.length) {
            if (uniqueElements.contains(A[i])) {
                break;
            }
            uniqueElements.add(A[i]);
            i++;
        }

        return A[i];
    }
    
}
