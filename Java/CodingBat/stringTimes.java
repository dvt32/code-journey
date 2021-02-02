// http://codingbat.com/prob/p142270

public String stringTimes(String str, int n) {
  StringBuilder output = new StringBuilder();
  for (int i = 0; i < n; ++i) {
    output.append(str);
  }
  return output.toString();
}

// Recursive solution (for fun)

/*
public String stringTimes(String str, int n) {
  if (n == 0) {
    return "";
  }
  
  return str + stringTimes(str, n-1);
}
*/
