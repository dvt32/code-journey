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

// Recursive solution (for fun)

/*
public int[] post4(int[] nums) {
  int lastFourIndex = getLastFourIndex(nums, nums.length-1);
  int[] newArray = new int[nums.length - lastFourIndex - 1];
  return getModifiedArr(newArray, nums, 0, lastFourIndex + 1);
}

public int getLastFourIndex(int[] nums, int i) {
  if (i == 0) {
    return 0;
  }
  
  if (nums[i] == 4) {
    return i;
  }
  
  return getLastFourIndex(nums, i-1);
}

public int[] getModifiedArr(int[] newArr, int[] nums, int i, int j) {
  if (i == newArr.length) {
    return newArr;
  }
  
  newArr[i] = nums[j];
  
  return getModifiedArr(newArr, nums, i+1, j+1);
}
*/
