// http://codingbat.com/prob/p100905

public String delDel(String str) {
  if (str.indexOf("del") == 1) {
    return str.substring(0, 1) + str.substring(4);
  }
  else {
    return str;
  }
}
