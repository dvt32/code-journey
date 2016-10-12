// http://codingbat.com/prob/p151940

public String withoutX(String str) {
  boolean needToRemoveFirstChar = (str.length() > 0 && str.charAt(0) == 'x');
  boolean needToRemoveLastChar = (str.length() > 0 && str.charAt(str.length()-1) == 'x');
  boolean needToRemoveBothChars = (str.length() > 1 && needToRemoveFirstChar && needToRemoveLastChar);
  
  if (needToRemoveBothChars) {
      return str.substring(1, str.length()-1);
  }
  else if (needToRemoveFirstChar) {
      return str.substring(1);
  }
  else if (needToRemoveLastChar) {
      return str.substring(0, str.length()-1);
  }
  else {
    return str;
  }
}
