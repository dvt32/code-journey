// http://codingbat.com/prob/p171260

public String stringX(String str) {
  if (str.length() >= 3) {
    return str.charAt(0) + str.substring(1, str.length()-1).replaceAll("x", "") + str.charAt(str.length()-1);
  }
  else {
    return str;
  }
}
