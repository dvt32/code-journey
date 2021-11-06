// https://leetcode.com/problems/queries-on-number-of-points-inside-a-circle/

class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] answer = new int[queries.length];
        
        for (int j = 0; j < queries.length; ++j) {
            int xj = queries[j][0];
            int yj = queries[j][1];
            int rj = queries[j][2];
            
            for (int i = 0; i < points.length; ++i) {
                int xi = points[i][0];
                int yi = points[i][1];
                // https://stackoverflow.com/questions/481144/equation-for-testing-if-a-point-is-inside-a-circle
                if ( (Math.pow(xi - xj, 2) + Math.pow(yi - yj, 2)) <= Math.pow(rj, 2) ) {
                    answer[j]++;
                }
            }
        }
        
        return answer;
    }
}
