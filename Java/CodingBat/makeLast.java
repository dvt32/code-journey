// http://codingbat.com/prob/p137188

public int[] makeLast(int[] nums) {
  int[] newArray = new int[nums.length * 2];
  int lastIndexOfNums = nums.length- 1;
  int lastIndexOfNewArray = newArray.length - 1;
  newArray[lastIndexOfNewArray] = nums[lastIndexOfNums];
  return newArray;
}
