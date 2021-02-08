// http://codingbat.com/prob/p121596

public String altPairs(String str) {
  if (str.length() <= 2) {
    return str;
  }
  
  StringBuilder output = new StringBuilder();
  for (int i = 0; i < str.length(); i += 4) {
    output.append(str.charAt(i));
    if (i+1 < str.length()) {
      output.append(str.charAt(i+1));
    }
  }
  return output.toString();
}

// Recursive solution (for fun)

/*
public String altPairs(String str) {
  if (str.length() <= 2) {
    return str;
  }
  if (str.length() <= 4) {
    return str.substring(0, 2);
  }
  
  return str.substring(0, 2) + altPairs(str.substring(4));
}
*/
