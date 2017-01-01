// http://codingbat.com/prob/p192570

public String withoutString(String base, String remove) {
  return base.replaceAll("(?i)" + remove, ""); // (?i) means ignore case
}
