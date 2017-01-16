// http://codingbat.com/prob/p102145

public boolean twoTwo(int[] nums) {
  for (int i = 0; i < nums.length; ++i) {
    boolean twoToTheLeft = (i-1 >= 0 && nums[i-1] == 2);
    boolean twoToTheRight = (i+1 < nums.length && nums[i+1] == 2);
    
    if (nums[i] == 2 && !twoToTheLeft && !twoToTheRight) {
      return false;
    }
  }
  
  return true;
}
