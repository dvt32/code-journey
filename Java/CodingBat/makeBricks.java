// http://codingbat.com/prob/p183562

public boolean makeBricks(int small, int big, int goal) {
  int totalBricks = (big * 5 + small);
  
  if (goal > totalBricks) {
    return false;
  }
  
  if (goal % 5 > small) {
    return false;
  }
  
  return true;
}
