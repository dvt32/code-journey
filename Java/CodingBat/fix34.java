// http://codingbat.com/prob/p159339

public int[] fix34(int[] nums) {
  for (int i = 0; i < nums.length; ++i) {
    if (nums[i] == 3) {
      int temp = nums[i+1];
      nums[i+1] = 4;
      for (int j = i+2; j < nums.length; ++j) {
        if (nums[j] == 4) {
          nums[j] = temp;
        }
      }
    }
  }
  
  return nums;
}

// Recursive solution (for fun)

/*
public int[] fix34(int[] nums) {
  return fix34(nums, 0);
}

public int[] fix34(int[] nums, int i) {
  if (i == nums.length) {
    return nums;
  }

  if (nums[i] == 3) {
    int temp = nums[i+1];
    nums[i+1] = 4;
    assignTempValue(nums, i+2, temp);
  }
  
  return fix34(nums, i+1);
}

public void assignTempValue(int[] nums, int j, int temp) {
  if (j < nums.length) {
    if (nums[j] == 4) {
      nums[j] = temp;
    }
    assignTempValue(nums, j+1, temp);
  }
}
*/
