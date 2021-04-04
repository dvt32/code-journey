// http://codingbat.com/prob/p127384

public int sum13(int[] nums) {
  if (nums.length == 0) {
    return 0;
  }
  else {
    int sum = 0;
    for (int i = 0; i < nums.length;) {
      if (nums[i] == 13) {
        i += 2;
      }
      else {
        sum += nums[i];
        ++i;
      }
    }
    return sum;
  }
}

// Recursive solution (for fun)

/*
public int sum13(int[] nums) {
  if (nums.length == 0) {
    return 0;
  }
  
  return sum13(nums, 0);
}

public int sum13(int[] nums, int i) {
  if (i >= nums.length) {
    return 0;
  }
  
  if (nums[i] == 13) {
    return sum13(nums, i+2);
  }
  
  return nums[i] + sum13(nums, i+1);
}
*/
