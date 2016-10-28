// http://codingbat.com/prob/p184029

public int countHi(String str) {
  if (str.length() == 1 || str.length() == 0) {
    return 0;
  }
  
  if (str.charAt(str.length()-2) == 'h' && str.charAt(str.length()-1) == 'i') {
    return countHi(str.substring(0, str.length()-1)) + 1;
  }
  else {
    return countHi(str.substring(0, str.length()-1));
  }
}
