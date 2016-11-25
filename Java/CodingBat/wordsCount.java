// http://codingbat.com/prob/p124620

public int wordsCount(String[] words, int len) {
  int wordsCount = 0;
  
  for (String word : words) {
    if (word.length() == len) {
      wordsCount++;
    }
  }
  
  return wordsCount;
}
