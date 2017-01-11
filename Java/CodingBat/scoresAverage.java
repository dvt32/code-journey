// http://codingbat.com/prob/p123837

public int scoresAverage(int[] scores) {
  return Math.max(
    average(scores, 0, scores.length / 2), 
    average(scores, scores.length / 2, scores.length)
  );
}

public int average(int[] scores, int start, int end) {
  int elementCount = 0;
  int sum = 0;
  
  for (int i = start; i < end; ++i) {
    sum += scores[i];
    elementCount++;
  }
  
  int average = (elementCount > 0) ? sum / elementCount : 0;
  
  return average;
}
