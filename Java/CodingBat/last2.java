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
