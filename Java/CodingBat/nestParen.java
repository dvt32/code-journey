// http://codingbat.com/prob/p183174

public boolean nestParen(String str) {
  if (str.length() == 0) {
    return true;
  }
  
  char firstChar = str.charAt(0);
  char lastChar = str.charAt(str.length()-1);
  
  if (firstChar == '(' && lastChar == ')') {
    return nestParen( str.substring(1, str.length()-1) );
  }
  else {
    return false;
  }
}
