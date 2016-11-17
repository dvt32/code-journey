// http://codingbat.com/prob/p160543

public String alarmClock(int day, boolean vacation) {
  String result = "";
  boolean isWeekday = (day >= 1 && day <= 5);
  
  if (vacation) {
    if (isWeekday) {
      result = "10:00";
    }
    else {
      result = "off";
    }
  }
  else {
    if (isWeekday) {
      result = "7:00";
    }
    else {
      result = "10:00";
    }
  }
  
  return result;
}
