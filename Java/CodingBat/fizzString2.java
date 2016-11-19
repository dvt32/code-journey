// http://codingbat.com/prob/p115243

public String fizzString2(int n) {
  if (n % 3 == 0 && n % 5 == 0) {
    return "FizzBuzz!";
  }
  else if (n % 3 == 0) {
    return "Fizz!";
  }
  else if (n % 5 == 0) {
    return "Buzz!";
  }
  else {
    return Integer.toString(n) + "!";
  }
}
