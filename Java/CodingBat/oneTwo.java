// http://codingbat.com/prob/p122943

public String oneTwo(String str) {
  if (str.length() < 3) {
    return "";
  }
  
  StringBuilder sb = new StringBuilder();
  
  for (int i = 0; i < str.length() - 2; i += 3) {
    sb.append(str.charAt(i+1));
    sb.append(str.charAt(i+2));
    sb.append(str.charAt(i));
  }
  
  return sb.toString();
}
