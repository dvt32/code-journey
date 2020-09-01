// https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/

class Solution {
    
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        
        for (int i = 0; i < salary.length; ++i) {
            min = Math.min(salary[i], min);
            max = Math.max(salary[i], max);
            sum += salary[i];
        }
        
        sum -= min;
        sum -= max;
        
        double result = ((double) sum) / (salary.length-2);
        
        return result;
    }
    
}
