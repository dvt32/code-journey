// http://codingbat.com/prob/p126332

public Map<String, String> pairs(String[] strings) {
  Map<String, String> firstAndLastCharacter = new HashMap<String, String>();
  for (String string : strings) {
    String firstCharacter = Character.toString(string.charAt(0));
    String lastCharacter = Character.toString(string.charAt(string.length()-1));
    firstAndLastCharacter.put(firstCharacter, lastCharacter);
  }
  return firstAndLastCharacter;
}
