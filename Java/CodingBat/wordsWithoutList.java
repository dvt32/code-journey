// http://codingbat.com/prob/p183407

public List wordsWithoutList(String[] words, int len) {
  List<String> wordsWithoutList = new ArrayList<String>();
  
  for (String word : words) {
    if (word.length() != len) {
      wordsWithoutList.add(word);
    }
  }
  
  return wordsWithoutList;
}
