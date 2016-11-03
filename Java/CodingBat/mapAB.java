// http://codingbat.com/prob/p107259// 

public Map<String, String> mapAB(Map<String, String> map) {
  boolean bothKeysPresent = (map.containsKey("a") && map.containsKey("b"));
  if (bothKeysPresent) {
    map.put("ab", map.get("a") + map.get("b"));
  }
  return map;
}
