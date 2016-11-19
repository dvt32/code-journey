// http://codingbat.com/prob/p140272

public boolean inOrderEqual(int a, int b, int c, boolean equalOk) {
  boolean areInStrictIncreasingOrder = (b > a && c > b);
  boolean areInIncreasingOrder = (b >= a && c >= b);
  
  if (equalOk && areInIncreasingOrder) {
    return true;
  }
  else if (areInStrictIncreasingOrder) {
    return true;
  }
  else {
    return false;
  }
}
