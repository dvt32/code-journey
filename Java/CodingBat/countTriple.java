// http://codingbat.com/prob/p195714

public int countTriple(String str) {
  int triplesCount = 0;
  
  for (int i = 0; i < str.length()-2; ++i) {
    if (str.charAt(i) == str.charAt(i+1) &&
        str.charAt(i) == str.charAt(i+2)) 
    {
       triplesCount++;   
    }
  }
  
  return triplesCount;
}
