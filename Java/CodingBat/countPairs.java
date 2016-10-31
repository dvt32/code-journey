// http://codingbat.com/prob/p154048

public int countPairs(String str) {
  if (str.length() <= 2) {
    return 0;
  }
  
  if (str.charAt(0) == str.charAt(2)) {
    return countPairs(str.substring(1)) + 1;
  }
  else {
    return countPairs(str.substring(1));
  }
}
