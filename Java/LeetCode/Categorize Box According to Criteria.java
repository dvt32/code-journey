// https://leetcode.com/problems/categorize-box-according-to-criteria

class Solution {

    public String categorizeBox(int length, int width, int height, int mass) {
        long volume = (long) length * width * height;
        boolean isBulky =
            (length >= 10000 || width >= 10000 || height >= 10000 || mass >= 10000) ||
            (volume >= 1_000_000_000);
        boolean isHeavy = (mass >= 100);
        

        if (isBulky && isHeavy) return "Both";
        if (isBulky && !isHeavy) return "Bulky";
        if (!isBulky && isHeavy) return "Heavy";

        return "Neither";
    }

}
