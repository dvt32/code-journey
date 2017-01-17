// http://codingbat.com/prob/p100246

public int[] pre4(int[] nums) {
  int newArrayLength = 0;
  
  for (int i = 0; i < nums.length; ++i) {
    if (nums[i] != 4) {
      newArrayLength++;
    }
    else {
      break;
    }
  }
  
  int[] newArray = new int[newArrayLength];
  
  for (int i = 0; i < newArrayLength; ++i) {
    newArray[i] = nums[i];
  }
  
  return newArray;
}
