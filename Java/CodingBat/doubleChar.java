// http://codingbat.com/prob/p165312

public String doubleChar(String str) {
    String output = "";
    for (int i = 0; i < str.length(); ++i) {
      output += String.valueOf(str.charAt(i)) + String.valueOf(str.charAt(i));
    }
    return output;
}
