// http://codingbat.com/prob/p179487

public boolean scores100(int[] scores) {
  for (int i = 1; i < scores.length; ++i) {
    if (scores[i] == 100 && scores[i-1] == 100) {
      return true;
    }
  }
  
  return false;
}

// Recursive solution (for fun)

/*
public boolean scores100(int[] scores) {
  if (scores.length <= 1) {
    return false;
  }
  
  return scores100(scores, 1);
}

public boolean scores100(int[] scores, int i) {
  if (i == scores.length) {
    return false;
  }
  
  if (scores[i] == 100 && scores[i-1] == 100) {
    return true;
  }
  
  return scores100(scores, i+1);
}
*/
