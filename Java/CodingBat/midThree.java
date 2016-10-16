// http://codingbat.com/prob/p155713

public int[] midThree(int[] nums) {
  int middleIndex = nums.length / 2;
  return new int[] { nums[middleIndex-1], nums[middleIndex], nums[middleIndex+1] };
}
