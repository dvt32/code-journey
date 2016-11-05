// http://codingbat.com/prob/p103593

public String wordAppend(String[] strings) {
  StringBuilder result = new StringBuilder();
  Map<String, Integer> instancesOfWords = new HashMap<String, Integer>();
  for (String word : strings) {
    int instancesOfWordCount = (!instancesOfWords.containsKey(word)) ? 0 : instancesOfWords.get(word);
    instancesOfWords.put(word, instancesOfWordCount + 1);
    instancesOfWordCount = instancesOfWords.get(word);
    if (instancesOfWordCount % 2 == 0) {
      result.append(word);
    }
  }
  return result.toString();
}
