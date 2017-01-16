// http://codingbat.com/prob/p134300

public boolean sameEnds(int[] nums, int len) {
  for (int i = 0, j = len; i < len; ++i, --j) {
    if (nums[i] != nums[nums.length - j]) {
      return false;
    }
  }
  
  return true;
}
