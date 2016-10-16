// http://codingbat.com/prob/p199519

public int[] makeMiddle(int[] nums) {
  int middleIndex = nums.length / 2;
  return new int[] { nums[middleIndex-1], nums[middleIndex] };
}
