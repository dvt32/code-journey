// http://codingbat.com/prob/p137918

public String parenBit(String str) {
  if (str.length() == 0) {
    return str;
  }

  if (str.charAt(0) == '(') {
    return str.substring(0, str.indexOf(')')+1);
  }
  else {
    return parenBit(str.substring(1));
  }
}
