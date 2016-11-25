// http://codingbat.com/prob/p121236

public String[] wordsWithout(String[] words, String target) {
  int lengthOfNewArray = 0;
  for (String word : words) {
    if (!word.equals(target)) {
      lengthOfNewArray++;
    }
  }
  
  String[] wordsWithout = new String[lengthOfNewArray];
  for (int i = 0, j = 0; i < words.length; ++i) {
    if (!words[i].equals(target)) {
      wordsWithout[j] = words[i];
      j++;
    }
  }
  
  return wordsWithout;
}
