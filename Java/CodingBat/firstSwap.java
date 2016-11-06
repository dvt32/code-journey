// http://codingbat.com/prob/p150113

public String[] firstSwap(String[] strings) {
  Map<Character, Integer> map = new HashMap<Character, Integer>();
  for (int i = 0; i < strings.length; ++i) {
    char firstChar = strings[i].charAt(0);
    if (!map.containsKey(firstChar)) {
      map.put(firstChar, i);
    }
    else if (map.get(firstChar) != -1) {
      String temp = strings[i];
      strings[i] = strings[map.get(firstChar)];
      strings[map.get(firstChar)] = temp;
      map.put(firstChar, -1);
    }
  }
  return strings;
}
