// http://codingbat.com/prob/p167430

public boolean has271(int[] nums) {
  for (int i = 0; i < (nums.length-2); ++i) {
    int value = nums[i];
    
    if (nums[i+1] == (value+5) && nums[i+2] == (value-1))
    {
      return true;
    }
    
    int correctValue = (value-1);
    boolean differsByTwoOrLess = 
      !(nums[i+2] > correctValue+2) && 
      !(nums[i+2] < correctValue-2);
    
    if (nums[i+1] == (value+5) && differsByTwoOrLess) {
      return true;
    }
  }
  
  return false;
}
