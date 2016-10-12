// http://codingbat.com/prob/p151359

public String withoutX2(String str) {
  boolean needToRemoveFirstChar = (str.length() > 0 && str.charAt(0) == 'x');
  boolean needToRemoveSecondChar = (str.length() > 1 && str.charAt(1) == 'x');
  boolean needToRemoveBothChars = (str.length() > 1 && needToRemoveFirstChar && needToRemoveSecondChar);
  
  if (needToRemoveBothChars) {
      return str.substring(2);
  }
  else if (needToRemoveFirstChar) {
      return str.substring(1);
  }
  else if (needToRemoveSecondChar) {
      return str.substring(0,1) + str.substring(2);
  }
  else {
    return str;
  }
}
