// http://codingbat.com/prob/p169260

public boolean has12(int[] nums) {
  boolean has1 = false;
  
  for (int i = 0; i < nums.length; ++i) {
    if (nums[i] == 1) {
      has1 = true;
    }
    else if (nums[i] == 2 && has1) {
      return true;
    }
  }
  
  return false;
}
