// http://codingbat.com/prob/p162010

public int countEvens(int[] nums) {
  int evenNumbersCount = 0;
  for (int number : nums) {
    if (number % 2 == 0) {
      evenNumbersCount++;
    }
  }
  return evenNumbersCount;
}
