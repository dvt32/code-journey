// http://codingbat.com/prob/p134300

public boolean sameEnds(int[] nums, int len) {
  for (int i = 0, j = len; i < len; ++i, --j) {
    if (nums[i] != nums[nums.length - j]) {
      return false;
    }
  }
  
  return true;
}

// Recursive solution (for fun)

/*
public boolean sameEnds(int[] nums, int len) {
  return sameEnds(nums, len, 0, len);
}

public boolean sameEnds(int[] nums, int len, int i, int j) {
  if (i == len) {
    return true;
  }
  
  if (nums[i] != nums[nums.length - j]) {
    return false;
  }
  
  return sameEnds(nums, len, i+1, j-1);
}
*/
