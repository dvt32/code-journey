// http://codingbat.com/prob/p112564

public boolean or35(int n) {
  boolean isMultipleOf3or5 = ((n % 3 == 0) || (n % 5 == 0));
  return isMultipleOf3or5;
}
