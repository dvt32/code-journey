// http://codingbat.com/prob/p118077

public int sumLimit(int a, int b) {
  int aDigitCount = String.valueOf(a).length();
  int sumDigitCount = String.valueOf(a + b).length();
  
  if (sumDigitCount > aDigitCount) {
    return a;
  }
  else {
    return a + b;
  }
}
