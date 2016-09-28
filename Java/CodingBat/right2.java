// http://codingbat.com/prob/p130781

public String right2(String str) {
  return str.substring(str.length()-2) + str.substring(0, str.length()-2);
}
