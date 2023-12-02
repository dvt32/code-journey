// https://leetcode.com/problems/cells-in-a-range-on-an-excel-sheet

class Solution {

    public List<String> cellsInRange(String s) {
        char r1 = s.charAt(0);
        char r2 = s.charAt(3);
        int c1 = Character.getNumericValue( s.charAt(1) );
        int c2 = Character.getNumericValue( s.charAt(4) );

        List<String> result = new ArrayList<>();
        for (char r = r1; r <= r2; ++r) {
            for (int c = c1; c <= c2; ++c) {
                result.add("" + r + c);
            }
        }

        return result;
    }

}
