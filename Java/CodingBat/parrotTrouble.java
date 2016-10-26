// http://codingbat.com/prob/p140449

public boolean parrotTrouble(boolean talking, int hour) {
  return (talking && (hour < 7 || hour > 20));
}
