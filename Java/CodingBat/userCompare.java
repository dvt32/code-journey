// http://codingbat.com/prob/p143482

public int userCompare(String aName, int aId, String bName, int bId) {
  if (aName.compareTo(bName) > 0) { // bName > aName
    return 1;
  }
  else if (aName.compareTo(bName) < 0) { // aName > bName
    return -1;
  }
  else { // aName == bName
    if (aId > bId) {
      return 1;
    }
    else if (bId > aId) {
      return -1;
    }
    else return 0;
  }
}
