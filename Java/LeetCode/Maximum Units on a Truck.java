// https://leetcode.com/problems/maximum-units-on-a-truck

class Solution {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(
            boxTypes, 
            (a, b) -> Integer.compare(b[1], a[1]) // reverse order by box unit count
        );

        int maxUnits = 0;

        for (int[] box : boxTypes) {
            if (truckSize >= box[0]) {
                maxUnits += box[0] * box[1];
                truckSize -= box[0];
            } else {
                maxUnits += truckSize * box[1];
                break;
            }
        }

        return maxUnits;
    }

}
