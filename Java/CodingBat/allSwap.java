// http://codingbat.com/prob/p134133

public String[] allSwap(String[] strings) {
  Map<Character, Integer> map = new HashMap<Character, Integer>();
  for (int i = 0; i < strings.length; ++i) {
    char firstChar = strings[i].charAt(0);
    if (!map.containsKey(firstChar)) {
      map.put(firstChar, i);
    }
    else if (map.containsKey(firstChar) && map.get(firstChar) < i) 
    {
      String temp = strings[i];
      strings[i] = strings[map.get(firstChar)];
      strings[map.get(firstChar)] = temp;
      map.remove(firstChar);
    }
  }
  return strings;
}
