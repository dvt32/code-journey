// http://codingbat.com/prob/p177372

public int max1020(int a, int b) {
  boolean aInRange = (a >= 10 && a <= 20);
  boolean bInRange = (b >= 10 && b <= 20);
  if (aInRange && bInRange) {
    return Math.max(a, b);
  }
  else if (!aInRange && bInRange) {
    return b;
  }
  else if (aInRange && !bInRange) {
    return a;
  }
  else {
    return 0;
  }
}
