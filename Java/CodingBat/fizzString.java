// http://codingbat.com/prob/p137136

public String fizzString(String str) {
  // alternatively use startsWith() and endsWith() String methods
  char firstChar = str.charAt(0); 
  char lastChar = str.charAt(str.length()-1);
  
  if (firstChar == 'f' && lastChar == 'b') {
    return "FizzBuzz";
  }
  else if (firstChar == 'f') {
    return "Fizz";
  }
  else if (lastChar == 'b') {
    return "Buzz";
  }
  else {
    return str;
  }
}
