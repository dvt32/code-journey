// http://codingbat.com/prob/p105771

public int[] evenOdd(int[] nums) {
  for (int i = 0; i < nums.length; ++i) {
    if (nums[i] % 2 == 0) {
      for (int j = i; j > 0; --j) {
        int temp = nums[j];
        nums[j] = nums[j-1];
        nums[j-1] = temp;
      }
    }
  }
  
  return nums;
}

// Recursive solution (for fun)

/*
public int[] evenOdd(int[] nums) {
  return evenOdd(nums, 0);
}

public int[] evenOdd(int[] nums, int i) {
  if (i == nums.length) {
    return nums;
  }
  
  if (nums[i] % 2 == 0) {
    for (int j = i; j > 0; --j) {
      int temp = nums[j];
      nums[j] = nums[j-1];
      nums[j-1] = temp;
    }
  }
  
  return evenOdd(nums, i+1);
}
*/
