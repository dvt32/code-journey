// http://codingbat.com/prob/p168493

public Map<String, String> firstChar(String[] strings) {
  Map<String, String> map = new HashMap<String, String>();
  for (String string : strings) {
    String firstChar = Character.toString(string.charAt(0));
    if (!map.containsKey(firstChar)) {
      map.put(firstChar, string);
    }
    else {
      map.put(firstChar, map.get(firstChar) + string);
    }
  }
  return map;
}
