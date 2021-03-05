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

// Recursive solution (for fun)

/*
public int bigHeights(int[] heights, int start, int end) {
  if (start == end) {
    return 0;
  }
  
  int abs = Math.abs( heights[start] - heights[start+1] );
  
  return (abs >= 5 ? 1 : 0) + bigHeights(heights, start+1, end);
}
*/
