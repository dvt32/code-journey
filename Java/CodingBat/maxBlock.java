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

// Recursive solution (for fun)

/*
public int maxBlock(String str) {
  if (str.length() < 2) {
    return str.length();
  }
  
  return maxBlock(str, 1, 1, 0);
}

public int maxBlock(String str, int maxAdjacentCharSequenceLength, int adjacentCharSequenceLength, int i) {
  if (i == str.length()-1) {
    return maxAdjacentCharSequenceLength;
  }
  
  if (str.charAt(i) == str.charAt(i+1)) {
    adjacentCharSequenceLength++;
    if (adjacentCharSequenceLength > maxAdjacentCharSequenceLength) {
      maxAdjacentCharSequenceLength = adjacentCharSequenceLength;
    }
  }
  else {
    adjacentCharSequenceLength = 1;
  }
  
  return maxBlock(str, maxAdjacentCharSequenceLength, adjacentCharSequenceLength, i+1);
}
*/
