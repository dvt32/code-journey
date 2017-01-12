// http://codingbat.com/prob/p180365

public int scoreUp(String[] key, String[] answers) {
  int score = 0;
  
  for (int i = 0; i < answers.length; ++i) {
    if (answers[i].equals(key[i])) {
      score += 4;
    }
    else if (answers[i].charAt(0) == '?') {
      continue;
    }
    else {
      score -= 1;
    }
  }
  
  return score;
}
