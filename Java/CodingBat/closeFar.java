// http://codingbat.com/prob/p138990

public boolean closeFar(int a, int b, int c) {
  int abAbs = Math.abs(a-b);
  int acAbs = Math.abs(a-c);
  int bcAbs = Math.abs(b-c);
  
  // totally readable code right here
  return ((abAbs <= 1 ^ acAbs <= 1) && ((abAbs >= 2 && bcAbs >= 2) ^ (acAbs >= 2 && bcAbs >= 2)));
}
