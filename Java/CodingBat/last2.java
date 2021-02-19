// http://codingbat.com/prob/p178318

public int last2(String str) {
  if (str.length() < 3) {
    return 0;
  }
  
  int count = 0;
  String lastTwoChars = str.substring(str.length()-2, str.length());
  
  for (int i = 0; i < str.length()-2; ++i) {
    if (str.substring(i, i+2).equals(lastTwoChars)) {
      count++;
    }
  }
  
  return count;
}

// Add recursive solution (for fun)

/*
public int last2(String str) {
  if (str.length() < 3) {
    return 0;
  }
  
  return last2(str, str.substring(str.length()-2), 0);
}

public int last2(String str, final String lastTwoChars, int i) {
  if (i == str.length()-2) {
    return 0;
  }
  
  if (str.substring(i, i+2).equals(lastTwoChars)) {
    return 1 + last2(str, lastTwoChars, i+1);
  }
  
  return last2(str, lastTwoChars, i+1);
}
*/
