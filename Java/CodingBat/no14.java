// http://codingbat.com/prob/p136648

public boolean no14(int[] nums) {
  boolean no4 = true;
  boolean no1 = true;
  
  for (int num : nums) {
    if (num == 1) {
      no1 = false;
    }
    else if (num == 4) {
      no4 = false;
    }
  }
  
  return (no1 || no4);
}
