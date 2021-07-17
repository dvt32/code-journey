// https://leetcode.com/problems/find-center-of-star-graph/

class Solution {

    public int findCenter(int[][] edges) {
        return 
            (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) 
            ? edges[0][0]
            : edges[0][1];
    }
    
    // Alternative solution
    /*
    public int findCenter(int[][] edges) {
        Integer[] arr = new Integer[] { edges[0][0], edges[0][1], edges[1][0], edges[1][1] };
        
        Set<Integer> set = new HashSet<>();
        for (int el : arr) {
            if (!set.add(el)) {
                return el;
            }
        }
        
        return -1;
    }
    */
      
}
