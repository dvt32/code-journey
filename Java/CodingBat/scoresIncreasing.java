// http://codingbat.com/prob/p146974

public boolean scoresIncreasing(int[] scores) {
  for (int i = 1; i < scores.length; ++i) {
    if (scores[i] < scores[i-1]) {
      return false;
    }
  }
  
  return true;
}
