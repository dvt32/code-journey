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
    nums[i] = getMaxOddValue(nums, i+1, 0);
  }
  
  return zeroMax(nums, i+1);
}

public int getMaxOddValue(int[] nums, int i, int maxOddValue) {
  if (i == nums.length) {
    return maxOddValue;
  }
  
  if (nums[i] % 2 == 1 && nums[i] > maxOddValue) {
    maxOddValue = nums[i];
  }

  return getMaxOddValue(nums, i+1, maxOddValue);
}
*/

// Alternative recursive solution without parameter for max odd value

/*
public int[] zeroMax(int[] nums) {
  return zeroMax(nums, 0);
}

public int[] zeroMax(int[] nums, int i) {
  if (i == nums.length) {
    return nums;
  }
  
  if (nums[i] == 0) {
    nums[i] = getMaxOddValue(nums, i+1);
  }
  
  return zeroMax(nums, i+1);
}

public int getMaxOddValue(int[] nums, int i) {
  if (i == nums.length) {
    return (nums[i-1] % 2 == 1) ? nums[i-1] : 0; 
  }
  
  if (nums[i] % 2 == 1) {
    return Math.max(nums[i], getMaxOddValue(nums, i+1));
  }

  return getMaxOddValue(nums, i+1);
}
*/
