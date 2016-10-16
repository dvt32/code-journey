// http://codingbat.com/prob/p142455

public int[] frontPiece(int[] nums) {
  return (nums.length < 2) ? nums : new int[] { nums[0], nums[1] };
}
