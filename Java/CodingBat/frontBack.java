// http://codingbat.com/prob/p123384

public String frontBack(String str) {
  if (str.length() <= 1) {
    return str;
  }
  else {
    return String.valueOf(str.charAt(str.length()-1)) + 
         str.substring(1, str.length()-1) +
         String.valueOf(str.charAt(0));
  }
}
