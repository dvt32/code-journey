// http://codingbat.com/prob/p179479

public int maxBlock(String str) {
  if (str.length() < 1) {
    return 0;
  }
  
  int maxAdjacentCharSequenceLength = 1;
  int adjacentCharSequenceLength = 1;
  
  for (int i = 0; i < str.length()-1; ++i) {
    if (str.charAt(i) == str.charAt(i+1)) {
      adjacentCharSequenceLength++;
      if (adjacentCharSequenceLength > maxAdjacentCharSequenceLength) {
        maxAdjacentCharSequenceLength = adjacentCharSequenceLength;
      }
    }
    else {
      adjacentCharSequenceLength = 1;
    }
  }
  
  return maxAdjacentCharSequenceLength;
}
