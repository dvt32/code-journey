// http://codingbat.com/prob/p185176

public int maxTriple(int[] nums) {
  int middleIndex = nums.length / 2;
  return Math.max(Math.max(nums[0], nums[middleIndex]), nums[nums.length-1]);
}
