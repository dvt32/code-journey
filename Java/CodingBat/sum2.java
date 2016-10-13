// http://codingbat.com/prob/p190968

public int sum2(int[] nums) {
  if (nums.length >= 2) {
    return nums[0] + nums[1];
  }
  else if (nums.length == 1) {
    return nums[0];
  }
  else {
    return 0;
  }
}
