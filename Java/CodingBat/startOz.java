// http://codingbat.com/prob/p199720

public String startOz(String str) {
  if (str.length() > 0) {
    return ((str.charAt(0) == 'o') ? "o" : "") +
           ((str.length() > 1 && str.charAt(1) == 'z') ? "z" : "");
  }
  else {
    return str;
  }
}
