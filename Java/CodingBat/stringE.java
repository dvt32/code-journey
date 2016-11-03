// http://codingbat.com/prob/p173784

public boolean stringE(String str) {
  int eCount = str.replaceAll("[^e]", "").length();
  return (eCount >= 1 && eCount <= 3);
}
