// http://codingbat.com/prob/p117334

public String stringSplosion(String str) {
  StringBuilder output = new StringBuilder();
  for (int i = 0; i < str.length(); ++i) {
    output.append(str.substring(0, i+1));
  }
  return output.toString();
}

// Recursive solution (for fun)

/*
int i = -1;
public String stringSplosion(String str) {
  i++;
  
  if (i == (str.length()-1)) {
    i = -1;
    return str;
  }
  
  return str.substring(0, i+1) + stringSplosion(str);
}
*/
