// http://codingbat.com/prob/p154137

public String notReplace(String str) {
  StringBuilder sb = new StringBuilder();
  
  for (int i = 0; i < str.length(); ++i) 
  {
    if (i-1 >= 0 && Character.isLetter(str.charAt(i-1)) ||  
        i+2 < str.length() && Character.isLetter(str.charAt(i+2))) 
    {
      sb.append(str.charAt(i));
    }
    else if (i+1 < str.length() && str.substring(i, i+2).equals("is")) 
    {
      sb.append("is not");
      i++;
    }
    else {
      sb.append(str.charAt(i));
    }
  }
  
  return sb.toString();
}
