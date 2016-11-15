// http://codingbat.com/prob/p159531

public boolean cigarParty(int cigars, boolean isWeekend) {
  boolean partyIsSuccessful;
  
  boolean cigarsInRange = (cigars >= 40 && cigars <= 60);
  if (cigarsInRange || (isWeekend && cigars >= 40)) {
    partyIsSuccessful = true;
  }
  else {
    partyIsSuccessful = false;
  }

  return partyIsSuccessful;
}
