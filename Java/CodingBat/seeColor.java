// http://codingbat.com/prob/p199216

public String seeColor(String str) {
  if (str.length() > 2 && str.substring(0, 3).equals("red")) {
    return "red";
  }
  else if (str.length() > 3 && str.substring(0, 4).equals("blue")) {
    return "blue";
  }
  else {
    return "";
  }
}
