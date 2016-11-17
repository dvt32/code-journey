// http://codingbat.com/prob/p157733

public int caughtSpeeding(int speed, boolean isBirthday) {
  int result = -1;
  int BIRTHDAY_EXTRA_SPEED = 5;
  
  if (!isBirthday) {
      if (speed <= 60) { 
        result = 0; 
      }
      else if (speed >= 61 && speed <= 80) { 
        result = 1;
      }
      else if (speed >= 81) {
        result = 2;
      }
  }
  else if (isBirthday) {
    if (speed <= 60 + BIRTHDAY_EXTRA_SPEED) { 
      result = 0; 
    }
    else if (speed >= 61 + BIRTHDAY_EXTRA_SPEED && speed <= 80 + BIRTHDAY_EXTRA_SPEED) { 
      result = 1;
    }
    else if (speed >= 81 + BIRTHDAY_EXTRA_SPEED) {
      result = 2;
    }
  }
  
  return result;
}
