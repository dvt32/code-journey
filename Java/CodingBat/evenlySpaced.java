// http://codingbat.com/prob/p198700

public boolean evenlySpaced(int a, int b, int c) {
  int large = Math.max(a, Math.max(b, c));
  int small = Math.min(a, Math.min(b, c));
  int medium = (a+b+c) - large - small;
  
  int smallMediumDifference = Math.abs(small - medium);
  int mediumLargeDifference = Math.abs(medium - large);
  
  if (smallMediumDifference == mediumLargeDifference) {
    return true;
  }
  else {
    return false;
  }
}
