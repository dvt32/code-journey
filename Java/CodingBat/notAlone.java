// http://codingbat.com/prob/p169506

public int[] notAlone(int[] nums, int val) {
  for (int i = 1; i < nums.length-1; ++i) {
    if (nums[i] == val &&
        nums[i] != nums[i-1] &&
        nums[i] != nums[i+1]) 
    {
       nums[i] = Math.max(nums[i-1], nums[i+1]);
    }
  }
  
  return nums;
}

// Recursive solution (for fun)

/*
public int[] notAlone(int[] nums, int val) {
  if (nums.length <= 1) {
    return nums;
  }
  
  return notAlone(nums, val, 1);
}

public int[] notAlone(int[] nums, int val, int i) {
  if (i == nums.length-1) {
    return nums;
  }
  
  if (nums[i] == val &&
      nums[i] != nums[i-1] &&
      nums[i] != nums[i+1]) 
  {
     nums[i] = Math.max(nums[i-1], nums[i+1]);
  }
  
  return notAlone(nums, val, i+1);
}
*/
