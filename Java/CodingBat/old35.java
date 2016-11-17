// http://codingbat.com/prob/p159612

public boolean old35(int n) {
  boolean isMultiple3 = (n % 3 == 0);
  boolean isMultiple5 = (n % 5 == 0);
  
  return (isMultiple3 ^ isMultiple5);
}
