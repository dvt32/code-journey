// http://codingbat.com/prob/p199612

public boolean sum28(int[] nums) {
  int sum = 0;
  for (int num : nums) {
    if (num == 2) {
      sum += 2;
    }
  }
  
  return (sum == 8);
}
