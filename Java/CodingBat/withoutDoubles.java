// http://codingbat.com/prob/p115233

public int withoutDoubles(int die1, int die2, boolean noDoubles) {
  if (noDoubles && die1 == die2) {
    return (die1 == 6) ? die1 + 1 : die1 + die2 + 1;
  }
  else {
    return die1 + die2;
  }
}
