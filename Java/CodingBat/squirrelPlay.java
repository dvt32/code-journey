// http://codingbat.com/prob/p141061

public boolean squirrelPlay(int temp, boolean isSummer) {
  boolean temperatureIsGood = (temp >= 60 && temp <= 90);
  boolean temperatureIsGoodForSummer = (temp >= 60 && temp <= 100);
  
  if (temperatureIsGood && !isSummer) {
    return true;
  }
  else if (isSummer && temperatureIsGoodForSummer) {
    return true;
  }
  else {
    return false;
  }
}
