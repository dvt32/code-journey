// http://codingbat.com/prob/p109660

public int start1(int[] a, int[] b) {
  int numberOfArrays = 0;
  if (a.length > 0 && a[0] == 1) {
    numberOfArrays++;
  }
  if (b.length > 0 && b[0] == 1) {
    numberOfArrays++;
  }
  return numberOfArrays;
}
