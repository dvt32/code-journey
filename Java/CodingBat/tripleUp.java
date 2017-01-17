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
