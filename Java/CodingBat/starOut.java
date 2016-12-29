// http://codingbat.com/prob/p139564

public String starOut(String str) {
  StringBuilder sb = new StringBuilder();
  
  for (int i = 0; i < str.length(); ++i) {
    if (str.charAt(i) != '*') {
      if (i > 0 && str.charAt(i-1) == '*') {
        continue;
      }
      else if (i < str.length()-1 && str.charAt(i+1) == '*') {
        continue;
      }
      else {
        sb.append(str.charAt(i));
      }
    }
  }
  
  return sb.toString();
}
