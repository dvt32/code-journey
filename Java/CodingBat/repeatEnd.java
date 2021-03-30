// http://codingbat.com/prob/p152339

public String repeatEnd(String str, int n) {
  StringBuilder output = new StringBuilder();
  for (int i = 0; i < n; ++i) {
    output.append(str.substring(str.length()-n));
  }
  return output.toString();
}

// Recursive solution (for fun)

/*
public String repeatEnd(String str, int n) {
  return repeatEnd(str, n, 0);

}

public String repeatEnd(String str, int n, int i) {
  if (i == n) {
    return "";
  }
  
  return str.substring( str.length()-n ) + repeatEnd(str, n, i+1);
}
*/
