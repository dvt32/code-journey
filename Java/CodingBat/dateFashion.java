
// http://codingbat.com/prob/p103360

public int dateFashion(int you, int date) {
  int fashionLevel = -1;
  
  boolean someoneIsVeryFashionable = (you >= 8 || date >= 8);
  boolean someoneIsVeryUnfashionable = (you <= 2 || date <= 2);
  
  if (someoneIsVeryFashionable) {
    fashionLevel = 2;
  }
  
  if (someoneIsVeryUnfashionable) {
      fashionLevel = 0;
  }
  
  if (!someoneIsVeryFashionable && !someoneIsVeryUnfashionable) {
    fashionLevel = 1;
  }
  
  return fashionLevel;
}

// CodingBat better solution

/*

public int dateFashion(int you, int date) {
  // Check the <=2 case first, since it takes precedence
  // over the >=8 case.
  if (you <= 2 || date <= 2) {
    return 0;
  }
  else if (you >= 8 || date >= 8) {
    return 2;
  }
  else {
    return 1;
  }
}

*/
