// http://codingbat.com/prob/p181646

public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
  boolean weAreInTrouble = true;
  if ((aSmile && bSmile) || (!aSmile && !bSmile)) {
    return weAreInTrouble;
  }
  else {
    return !weAreInTrouble;
  }
}
