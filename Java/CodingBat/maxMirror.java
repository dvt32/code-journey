// http://codingbat.com/prob/p196409

public int maxMirror(int[] nums) {
    int maxMirrorLength = 0;
    
    for (int i = 0; i < nums.length; ++i) {
        for (int j = nums.length-1; j >= 0; --j) {
            int mirrorLength = 0;
            int numberSequenceIndex = i; // initially the start of the original sequence of numbers
            int mirrorSequenceIndex = j; // initially the start of the "mirror"
            
            while (numberSequenceIndex < nums.length && 
                   mirrorSequenceIndex >= 0 && 
                   nums[numberSequenceIndex] == nums[mirrorSequenceIndex]) 
            {
                mirrorLength++;
                numberSequenceIndex++;
                mirrorSequenceIndex--;
            }
                                                                              
            maxMirrorLength = Math.max(maxMirrorLength, mirrorLength);
        }
    }
                                                                                            
    return maxMirrorLength;
}
