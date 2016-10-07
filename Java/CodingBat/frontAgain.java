// http://codingbat.com/prob/p196652

// My apologies, I got quite lazy. :)

public boolean frontAgain(String str) {
  return (str.length() > 1) ? (str.substring(0, 2).equals(str.substring(str.length()-2, str.length()))) : false;
}
