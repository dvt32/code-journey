// http://codingbat.com/prob/p157900

public int sumHeights2(int[] heights, int start, int end) {
  int sum = 0;
  
  for (int i = start; i < end; ++i) {
    if (heights[i] < heights[i+1]) {
      sum += Math.abs(heights[i] - heights[i+1]) * 2;
    }
    else {
      sum += Math.abs(heights[i] - heights[i+1]);
    }
  }
  
  return sum;
}

// Recursive solution (for fun)

/*
public int sumHeights2(int[] heights, int start, int end) {
  if (start == end) {
    return 0;
  }
  
  int i = start;
  int sum = Math.abs(heights[i] - heights[i+1]);
  if (heights[i] < heights[i+1]) {
    sum *= 2;
  }
  
  return sum + sumHeights2(heights, start+1, end);
}
*/
