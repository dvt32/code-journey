// http://codingbat.com/prob/p198664

public boolean gHappy(String str) {
  boolean gHappy = true;
  
  for (int i = 0; i < str.length(); ++i) {
    if (str.charAt(i) == 'g') {
      if (i > 0 && str.charAt(i-1) == 'g') {
        gHappy = true;
      }
      else if (i < str.length()-1 && str.charAt(i+1) == 'g') {
        gHappy = true;
      }
      else {
        gHappy = false;
        return gHappy;
      }
    }
  }
  
  return gHappy;
}
