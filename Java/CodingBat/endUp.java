// http://codingbat.com/prob/p125268

public String endUp(String str) {
  return (str.length() < 3) 
          ? str.toUpperCase() 
          : str.substring(0, str.length()-3) + str.substring(str.length()-3).toUpperCase();
}
