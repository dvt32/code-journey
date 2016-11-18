// http://codingbat.com/prob/p178728

public int teenSum(int a, int b) {
  boolean isTeenValue = ((a >= 13 && a <= 19) || (b >= 13 && b <= 19));
  if (isTeenValue) {
    return 19;
  }
  else {
    return a + b;
  }
}
