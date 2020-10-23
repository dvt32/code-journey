// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/

class Solution {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int greatest = 0;
        for (int i = 0; i < candies.length; ++i) {
            greatest = Math.max(greatest, candies[i]);
        }
        
        List<Boolean> output = new ArrayList<>();
        for (int i = 0; i < candies.length; ++i) {
            if ((candies[i] + extraCandies) >= greatest) {
                output.add(true);
            }
            else {
                output.add(false);
            }
        }
        
        return output;
    }
    
}
