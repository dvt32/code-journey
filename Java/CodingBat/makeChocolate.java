// http://codingbat.com/prob/p191363

public int makeChocolate(int small, int big, int goal) {
  int totalBricks = (big * 5) + small;
  
  if (goal > totalBricks || goal % 5 > small) {
    return -1;
  }
  
  int bigBricksNeeded = goal / 5;
  int smallBricksNeeded = 
    (big >= bigBricksNeeded) ? goal - (bigBricksNeeded * 5) : goal - (big * 5);
  
  return smallBricksNeeded;
}
