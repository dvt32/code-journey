// http://codingbat.com/prob/p175689

public boolean no23(int[] nums) {
  boolean contains2 = (nums[0] == 2 || nums[1] == 2);
  boolean contains3 = (nums[0] == 3 || nums[1] == 3);
  if (!contains2 && !contains3) {
    return true;
  }
  else {
    return false;
  }
}
