// http://codingbat.com/prob/p180759

public String zipZap(String str) {
  if (str.length() < 3) {
    return str;
  }
  
  StringBuilder sb = new StringBuilder();
  
  sb.append(str.charAt(0));
  for (int i = 1; i < str.length()-1; ++i) {
    if (!(str.charAt(i-1) == 'z' && str.charAt(i+1) == 'p')) {
      sb.append(str.charAt(i));
    }
  }
  sb.append(str.charAt(str.length()-1));
  
  return sb.toString();
}
