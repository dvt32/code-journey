// http://codingbat.com/prob/p183837

public String[] wordsFront(String[] words, int n) {
  String[] wordsFront = new String[n];
  
  for (int i = 0; i < n; ++i) {
    wordsFront[i] = words[i];
  }
  
  return wordsFront;
}
