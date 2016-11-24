// http://codingbat.com/prob/p196640

public int bigDiff(int[] nums) {
  int max = nums[0];
  int min = nums[0];
  for (int num : nums) {
    if (num > max) {
      max = num;
    }
    else if (num < min) {
      min = num;
    }
  }
  return Math.abs(max-min);
}
