// http://codingbat.com/prob/p140485

public int scoresSpecial(int[] a, int[] b) {
  int sum = getMaxSpecialScore(a) + getMaxSpecialScore(b);
  
  return sum;
}

public int getMaxSpecialScore(int[] arr) {
  int max = 0;
  
  for (int element : arr) {
    if (element % 10 == 0 && element > max) {
      max = element;
    }
  }
  
  return max;
}
