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

// Recursive solution (for fun)

/*
public boolean scoresClump(int[] scores) {
  if (scores.length <= 2) {
    return false;
  }
  
  return scoresClump(scores, 2);
}

public boolean scoresClump(int[] scores, int i) {
  if (i == scores.length) {
    return false;
  }
  
  if (Math.abs(scores[i] - scores[i-1]) <= 2 &&
      Math.abs(scores[i] - scores[i-2]) <= 2 &&
      Math.abs(scores[i-1] - scores[i-2]) <= 2) 
  {
      return true;
  }
  
  return scoresClump(scores, i+1);
}
*/
