// http://codingbat.com/prob/p184031

public int arrayCount9(int[] nums) {
  int numberOfNines = 0;
  for (int number : nums) {
    if (number == 9) {
      numberOfNines++;
    }
  }
  return numberOfNines;
}
