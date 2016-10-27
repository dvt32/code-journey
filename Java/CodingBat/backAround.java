// http://codingbat.com/prob/p161642

public String backAround(String str) {
  return String.valueOf(str.charAt(str.length()-1)) + str + String.valueOf(str.charAt(str.length()-1));
}
