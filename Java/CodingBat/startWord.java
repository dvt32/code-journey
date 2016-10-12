// http://codingbat.com/prob/p141494

public String startWord(String str, String word) {
  if (str.length() >= word.length() && 
      str.substring(1, word.length()).equals(word.substring(1, word.length()))
     )
  {
    return str.substring(0, word.length());
  }
  else {
    return "";
  }
}
