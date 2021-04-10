// http://codingbat.com/prob/p193753

public int[] zeroFront(int[] nums) {
  for (int i = 0; i < nums.length; ++i) {
    if (nums[i] == 0) {
      int zeroIndex = i;
      while (zeroIndex > 0 && nums[zeroIndex-1] != 0) {
        int temp = nums[zeroIndex-1];
        nums[zeroIndex-1] = 0;
        nums[zeroIndex] = temp;
        zeroIndex--;
      }
    }
  }
  
  return nums;
}

// Recursive solution (for fun)

/*
public int[] zeroFront(int[] nums) {
  return zeroFront(nums, 0);
}

public int[] zeroFront(int[] nums, int i) {
  if (i == nums.length) {
    return nums;
  }
  
  if (nums[i] == 0) {
    int zeroIndex = i;
    alterNums(nums, zeroIndex, i);
  }
  
  return zeroFront(nums, i+1);
}

public void alterNums(int[] nums, int zeroIndex, int i) {
  if (zeroIndex > 0 && nums[zeroIndex-1] != 0) {
    int temp = nums[zeroIndex-1];
    nums[zeroIndex-1] = 0;
    nums[zeroIndex] = temp;
    zeroIndex--;
    
    alterNums(nums, zeroIndex, i);
  }
}
*/
