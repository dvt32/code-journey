// http://codingbat.com/prob/p117630

public Map<String, Integer> wordCount(String[] strings) {
  Map<String, Integer> map = new HashMap<String, Integer>();
  for (String string : strings) {
    int occurrencesOfString = (!map.containsKey(string)) ? 0 : map.get(string);
    map.put(string, occurrencesOfString + 1);
  }
  return map;
}
