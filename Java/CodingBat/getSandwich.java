// http://codingbat.com/prob/p129952

public String getSandwich(String str) {
  if (str.indexOf("bread") == str.lastIndexOf("bread")) {
    return "";
  }
  
  int firstAppearanceEndIndex = str.indexOf("bread") + 5;
  int lastAppearanceStartIndex = str.lastIndexOf("bread");
  
  return str.substring(firstAppearanceEndIndex, lastAppearanceStartIndex);
}
