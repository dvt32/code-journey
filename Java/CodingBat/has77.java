// http://codingbat.com/prob/p168357

public boolean has77(int[] nums) {
  for (int i = 0; i < nums.length - 1; ++i) {
    if ( nums[i] == nums[i+1] && nums[i] == 7 ) {
      return true;
    }
    else if ( i < nums.length-2 && nums[i] == nums[i+2] && nums[i] == 7 ) {
      return true;
    }
  }
  
  return false;
}
