// http://codingbat.com/prob/p152303

public Map<String, Integer> word0(String[] strings) {
  Map<String, Integer> myMap = new HashMap<String, Integer>();
  for (String string : strings) {
    myMap.put(string, 0);
  }
  return myMap;
}
