// https://leetcode.com/problems/calculate-digit-sum-of-a-string

class Solution {

    public String digitSum(String s, int k) {
        if (s.length() <= k) {
            return s;
        }

        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < s.length(); i += k) {
            String group = s.substring(i, Math.min(s.length(), i+k));

            int sum = 0;
            for (int j = 0; j < group.length(); ++j) {
                sum += Character.getNumericValue( group.charAt(j) );
            }

            newStr.append(String.valueOf(sum));
        }

        return digitSum(newStr.toString(), k);
    }

}
