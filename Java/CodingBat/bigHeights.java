// http://codingbat.com/prob/p197710

public int bigHeights(int[] heights, int start, int end) {
  int bigStepCount = 0;
  
  for (int i = start; i < end; ++i) {
    if (Math.abs(heights[i] - heights[i+1]) >= 5) {
      bigStepCount++;
    }
  }
  
  return bigStepCount;
}
