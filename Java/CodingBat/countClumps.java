// http://codingbat.com/prob/p193817

public int countClumps(int[] nums) {
  int clumpCount = 0;
  int clumpLength = 1;
  
  for (int i = 1; i < nums.length; ++i) {
    if (nums[i] == nums[i-1]) {
      if (clumpLength < 2) {
        clumpCount++;
        clumpLength++;
      }
    }
    else {
      clumpLength = 1;
    }
  }
  
  return clumpCount;
}
