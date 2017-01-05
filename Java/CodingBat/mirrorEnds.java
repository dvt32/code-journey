// http://codingbat.com/prob/p139411

public String mirrorEnds(String string) {
  if (string.length() < 2) {
    return string;
  }
  else if (string.equals(new StringBuilder(string).reverse().toString())) { // if string is a palindrome
    return string; 
  }
  
  for (int i = 0, j = string.length()-1; i < j; ++i, --j) {
    if (string.charAt(i) != string.charAt(j)) {
      return string.substring(0, i);
    }
  }
  
  return "";
}
