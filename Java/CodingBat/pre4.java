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

// Recursive solution (for fun)

/*
public int[] pre4(int[] nums) {
  int newArrayLength = getNewArrayLength(nums, 0);
  int[] newArray = new int[newArrayLength];
  newArray = getFilledNewArray(newArray, newArrayLength, nums, 0);
  return newArray;
}

public int getNewArrayLength(int[] nums, int i) {
  if (i == nums.length || nums[i] == 4) {
    return 0;
  }
  
  return 1 + getNewArrayLength(nums, i+1);
}

public int[] getFilledNewArray(int[] newArray, int newArrayLength, int[] nums, int i) {
  if (i == newArrayLength) {
    return newArray;
  }
  
  newArray[i] = nums[i];
  
  return getFilledNewArray(newArray, newArrayLength, nums, i+1);
}
*/
