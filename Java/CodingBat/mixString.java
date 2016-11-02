// http://codingbat.com/prob/p125185

public String mixString(String a, String b) {
  StringBuilder sb = new StringBuilder();
  
  for (int i = 0; i < a.length() || i < b.length(); ++i) {
    if (i < a.length()) {
      sb.append(a.charAt(i));
    }
    if (i < b.length()) {
      sb.append(b.charAt(i));
    }
  }
  
  return sb.toString();
}
