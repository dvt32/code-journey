// https://leetcode.com/problems/find-the-town-judge/

class Solution {
    
    public int findJudge(int n, int[][] trust) {
        if (n == 1) {
            return 1;
        }
        
        Map<Integer, Integer> trustCount = new HashMap<>();
        Set<Integer> trusters = new HashSet<>();
        
        for (int[] t : trust) {
            trusters.add(t[0]);
            int newCount = trustCount.getOrDefault(t[1], 0) + 1;
            trustCount.put(t[1], newCount);
        }
        
        for (Integer trustee : trustCount.keySet()) {
            if ( trustCount.get(trustee) == n-1 && !trusters.contains(trustee) ) {
                return trustee;
            }
        }
        
        return -1;
    }
    
}
