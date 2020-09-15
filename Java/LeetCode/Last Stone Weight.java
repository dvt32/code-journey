// https://leetcode.com/problems/last-stone-weight/

class Solution {

    public int lastStoneWeight(int[] stones) {
        List<Integer> stoneWeights = IntStream.of(stones).boxed().collect(Collectors.toList());
        
        while (stoneWeights.size() > 1) {
            Integer y = stoneWeights.get(0);
            Integer yIndex = 0;
    
            for (int i = 1; i < stoneWeights.size(); ++i) {
                Integer currentStoneWeight = stoneWeights.get(i);
                if (currentStoneWeight > y) {
                    y = currentStoneWeight;
                    yIndex = i;
                }
            }
            
            Integer x = Integer.MIN_VALUE;
            Integer xIndex = -1;
            
            for (int i = 0; i < stoneWeights.size(); ++i) {
                Integer currentStoneWeight = stoneWeights.get(i);
                if (currentStoneWeight > x && i != yIndex) {
                    x = currentStoneWeight;
                    xIndex = i;
                }
            }
            
            if (x == y) {
                stoneWeights.remove(x);
                stoneWeights.remove(y);
            }
            else {
                stoneWeights.set(yIndex, y-x);
                stoneWeights.remove(x);
            }
        }
        
        return (stoneWeights.size() == 0) ? 0 : stoneWeights.get(0);
    }
    
}
