// http://codingbat.com/prob/p171022

public boolean has23(int[] nums) {
  for (int number : nums) {
    if (number == 2 || number == 3) {
      return true;
    }
  }
  return false;
}
