// https://leetcode.com/problems/thousand-separator/

import java.text.NumberFormat;
import java.util.Locale;

class Solution {

    public String thousandSeparator(int n) {
        return NumberFormat.getNumberInstance(Locale.US).format(n).replace(",", ".");
    }
    
}
