// http://codingbat.com/prob/p137874

public boolean tripleUp(int[] nums) {
  for (int i = 1; i < nums.length-1; ++i) {
    int differenceBetweenFirstNumberAndSecondNumber = nums[i] - nums[i-1];
    int differenceBetweenSecondNumberAndThirdNumber = nums[i+1] - nums[i];
    
    if (differenceBetweenFirstNumberAndSecondNumber == 1 && 
        differenceBetweenSecondNumberAndThirdNumber == 1) 
    {
      return true;
    }
  }
  
  return false;
}

// Recursive solution (for fun)

/*
public boolean tripleUp(int[] nums) {
  if (nums.length < 3) {
    return false;
  }
  
  return tripleUp(nums, 1);
}

public boolean tripleUp(int[] nums, int i) {
  if (i == nums.length-1) {
    return false;
  }
  
  if ( 
       (nums[i] - nums[i-1]) == 1 && 
       (nums[i+1] - nums[i]) == 1
     )
  {
    return true;
  }
  
  return tripleUp(nums, i+1);
}
*/
