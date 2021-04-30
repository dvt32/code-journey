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

// Recursive solution (for fun)

/*
public int maxMirror(int[] nums) {
  int maxMirrorLength = 0;
  return maxMirror(nums, maxMirrorLength, 0, nums.length-1);
}

public int maxMirror(int[] nums, int maxMirrorLength, int i, int j) {
  if (i == nums.length) {
    return maxMirrorLength;
  }
  
  if (j >= 0) {
      int mirrorLength = calcMirrorLength(nums, i, j);
      maxMirrorLength = Math.max(maxMirrorLength, mirrorLength);
      return maxMirror(nums, maxMirrorLength, i, j-1);
  }
  
  return maxMirror(nums, maxMirrorLength, i+1, nums.length-1);
}

public int calcMirrorLength(int[] nums, int numberSequenceIndex, int mirrorSequenceIndex) {
  if (numberSequenceIndex < nums.length && 
      mirrorSequenceIndex >= 0 && 
      nums[numberSequenceIndex] == nums[mirrorSequenceIndex])
  {
    return 1 + calcMirrorLength(nums, numberSequenceIndex+1, mirrorSequenceIndex-1);
  }
  
  return 0;
}
*/
