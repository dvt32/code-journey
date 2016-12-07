// http://codingbat.com/prob/p117019
 
public int blackjack(int a, int b) {
  boolean aInRange = (a <= 21);
  boolean bInRange = (b <= 21);
  
  if (aInRange && bInRange) {
    return Math.min(Math.abs(21-a), Math.abs(21-b)) == Math.abs(21-a) ? a : b;
  }
  else if (aInRange && !bInRange) {
    return a;
  }
  else if (!aInRange && bInRange) {
    return b;
  }
  else {
    return 0;
  }
}
