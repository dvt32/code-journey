// http://codingbat.com/prob/p118044

public int[] swapEnds(int[] nums) {
  int temp = nums[0];
  nums[0] = nums[nums.length-1];
  nums[nums.length-1] = temp;
  return nums;
}
