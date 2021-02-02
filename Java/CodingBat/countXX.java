// http://codingbat.com/prob/p194667

int countXX(String str) {
  int xxCount = 0;
  for (int i = 0; i < str.length()-1; ++i) {
    if (str.substring(i, i+2).equals("xx")) {
      xxCount++;
    }
  }
  return xxCount;
 }

// Recursive solution

/*
int countXX(String str) {
  if ( !str.contains("xx") ) {
    return 0;
  }
  
  return 1 + countXX( str.substring(str.indexOf("xx")+1) );
}
*/
