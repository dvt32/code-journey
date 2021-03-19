// http://codingbat.com/prob/p187050

public int[] zeroMax(int[] nums) {
  for (int i = 0; i < nums.length; ++i) {
    if (nums[i] == 0) {
      int maxOddValue = 0;
      for (int j = i+1; j < nums.length; ++j) {
        if (nums[j] % 2 == 1 && nums[j] > maxOddValue) {
          maxOddValue = nums[j];
        }
      }
      nums[i] = maxOddValue;
    }
  }
  
  return nums;
}

// Recursive solution (for fun)

/*
public int[] zeroMax(int[] nums) {
  return zeroMax(nums, 0);
}

public int[] zeroMax(int[] nums, int i) {
  if (i == nums.length) {
    return nums;
  }
  
  if (nums[i] == 0) {
    nums[i] = getMaxOddValue(nums, i, i+1, 0);
  }
  
  return zeroMax(nums, i+1);
}

public int getMaxOddValue(int[] nums, int i, int j, int maxOddValue) {
  if (j == nums.length) {
    return maxOddValue;
  }
  
  if (nums[j] % 2 == 1 && nums[j] > maxOddValue) {
    maxOddValue = nums[j];
  }

  return getMaxOddValue(nums, i, j+1, maxOddValue);
}
*/
