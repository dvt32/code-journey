// http://codingbat.com/prob/p194530

public boolean scoresClump(int[] scores) {
  for (int i = 2; i < scores.length; ++i) {
    if (Math.abs(scores[i] - scores[i-1]) <= 2 &&
        Math.abs(scores[i] - scores[i-2]) <= 2 &&
        Math.abs(scores[i-1] - scores[i-2]) <= 2) 
    {
        return true;
    }
  }
  
  return false;
}
