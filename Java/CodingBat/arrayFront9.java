// http://codingbat.com/prob/p186031

public boolean arrayFront9(int[] nums) {
  int numberOfIterations = (nums.length <= 4) ? nums.length : 4;
  for (int i = 0; i < numberOfIterations; ++i) {
    if (nums[i] == 9) {
      return true;
    }
  }
  return false;
}
