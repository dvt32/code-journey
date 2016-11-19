// http://codingbat.com/prob/p154188

public boolean inOrder(int a, int b, int c, boolean bOk) {
  if (bOk == true && c > b) {
    return true;
  }
  else if (b > a && c > b) {
    return true;
  }
  else {
    return false;
  }
}
