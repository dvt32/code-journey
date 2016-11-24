// http://codingbat.com/prob/p179487

public boolean scores100(int[] scores) {
  for (int i = 1; i < scores.length; ++i) {
    if (scores[i] == 100 && scores[i-1] == 100) {
      return true;
    }
  }
  
  return false;
}
