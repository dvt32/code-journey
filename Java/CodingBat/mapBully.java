// http://codingbat.com/prob/p197888

public Map<String, String> mapBully(Map<String, String> map) {
  if (map.get("a") != null) { // map.containsKey("a")
    map.put("b", map.get("a"));
    map.put("a", "");
  }
  return map;
}
