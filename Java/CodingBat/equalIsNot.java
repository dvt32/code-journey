// http://codingbat.com/prob/p141736

public boolean equalIsNot(String str) {
  int isIndex = str.indexOf("is");
  int isCount = 0;
  
  int notIndex = str.indexOf("not");
  int notCount = 0;
  
  while (isIndex >= 0) {
    isCount++;
    isIndex = str.indexOf("is", isIndex + "is".length());
  }
  
  while (notIndex >= 0) {
    notCount++;
    notIndex = str.indexOf("not", notIndex + "not".length());
  }
  
  return (isCount == notCount);
}
