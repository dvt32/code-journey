// http://codingbat.com/prob/p147538

public String wordEnds(String str, String word) {
  StringBuilder sb = new StringBuilder();
  
  int i = 0;
  int wordIndex = str.indexOf(word);
  
  while (i < str.length()) {
    if (i == wordIndex) {
      if (i-1 >= 0) { 
        sb.append(str.charAt(i-1)); 
      }
      i += word.length();
      if (i < str.length()) { 
        sb.append(str.charAt(i)); 
      }
      wordIndex = str.indexOf(word, wordIndex + word.length());
    }
    else {
      i++;
    }
  }
  
  return sb.toString();
}
