// http://codingbat.com/prob/p137742

public boolean love6(int a, int b) {
  return (a == 6 || b == 6 || (a+b) == 6 || Math.abs(a-b) == 6);
}
