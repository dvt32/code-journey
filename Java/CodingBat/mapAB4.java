// http://codingbat.com/prob/p136950

public Map<String, String> mapAB4(Map<String, String> map) {
  if ( map.containsKey("a") && 
       map.containsKey("b") && 
       map.get("a").length() != map.get("b").length() 
     ) 
  {
    String max = 
      ( Math.max(map.get("a").length(), map.get("b").length()) == map.get("a").length() ) ? 
      map.get("a") : 
      map.get("b");
    map.put("c", max);
  }
  else if ( map.containsKey("a") && 
            map.containsKey("b") && 
            map.get("a").length() == map.get("b").length() 
        ) 
  {
    map.put("a", "");
    map.put("b", "");
  }
  
  return map;
}
