// http://codingbat.com/prob/p170829

public String plusOut(String str, String word) {
  StringBuilder sb = new StringBuilder();
  
  int wordIndex = str.indexOf(word);
  int i = 0;
  
  while (i < str.length()) {
    if (i == wordIndex) {
      sb.append(word);
      i += word.length();
      wordIndex = str.indexOf(word, wordIndex + word.length());
    }
    else {
      sb.append('+');
      i++;
    }
  }
  
  return sb.toString();
}
