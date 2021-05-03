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

// Recursive solution (for fun)

/*
public int countClumps(int[] nums) {
  return countClumps(nums, 0, 1, 1);
}

public int countClumps(int[] nums, int clumpCount, int clumpLength, int i) {
  if (i >= nums.length) {
    return clumpCount;
  }
  
  if (nums[i] == nums[i-1]) {
    if (clumpLength < 2) {
      clumpCount++;
      clumpLength++;
    }
  }
  else {
    clumpLength = 1;
  }
  
  return countClumps(nums, clumpCount, clumpLength, i+1);
}
*/
