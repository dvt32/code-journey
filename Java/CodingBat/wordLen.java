// http://codingbat.com/prob/p125327

public Map<String, Integer> wordLen(String[] strings) {
  Map<String, Integer> lengthOfWords = new HashMap<String, Integer>();
  for (String string : strings) {
    lengthOfWords.put(string, string.length());
  }
  return lengthOfWords;
}
