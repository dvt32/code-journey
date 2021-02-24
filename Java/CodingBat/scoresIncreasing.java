// http://codingbat.com/prob/p146974

public boolean scoresIncreasing(int[] scores) {
  for (int i = 1; i < scores.length; ++i) {
    if (scores[i] < scores[i-1]) {
      return false;
    }
  }
  
  return true;
}

// Recursive solution (for fun)

/*
public boolean scoresIncreasing(int[] scores) {
  return scoresIncreasing(scores, 1);
}

public boolean scoresIncreasing(int[] scores, int i) {
  if (i == scores.length) {
    return true;
  }
  
  if (scores[i] < scores[i-1]) {
    return false;
  }
  
  return scoresIncreasing(scores, i+1);
}
*/
