// http://codingbat.com/prob/p164144

public int[] post4(int[] nums) {
  int lastFourIndex = 0;
  for (int i = 1; i < nums.length; ++i) {
    if (nums[i] == 4) {
      lastFourIndex = i;
    }
  }
  
  int[] newArray = new int[nums.length - lastFourIndex - 1];
  
  int j = lastFourIndex + 1;
  for (int i = 0; i < newArray.length; ++i) {
    newArray[i] = nums[j];
    j++;
  }
  
  return newArray;
}
