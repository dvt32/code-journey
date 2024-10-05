// https://leetcode.com/problems/convert-date-to-binary/

class Solution {

    public String convertDateToBinary(String date) {
        String[] parts = date.split("-");

        for (int i = 0; i < parts.length; ++i) {
            parts[i] = Integer.toBinaryString( Integer.parseInt(parts[i]) );
        }

        return String.join("-", parts);
    }

    // Alternative
    /*
    public String convertDateToBinary(String date) {
        return Stream.of(date.split("-")).map(part -> Integer.toBinaryString(Integer.parseInt(part))).collect(Collectors.joining("-"));
    }
    */

}
