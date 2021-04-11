// http://codingbat.com/prob/p153059

public String[] fizzBuzz(int start, int end) {
  String[] numbers = new String[end-start];
  
  for (int i = 0; i < numbers.length; ++i) {
    int number = (start + i);
    if (number % 3 == 0 && number % 5 == 0) {
      numbers[i] = "FizzBuzz";
    }
    else if (number % 3 == 0) {
      numbers[i] = "Fizz";
    }
    else if (number % 5 == 0) {
      numbers[i] = "Buzz";
    }
    else {
      numbers[i] = String.valueOf(number);
    }
  }
  
  return numbers;
}

// Recursive solution (for fun)

/*
public String[] fizzBuzz(int start, int end) {
  String[] numbers = new String[end-start];
  return fizzBuzz(numbers, start, 0);
}

public String[] fizzBuzz(String[] numbers, int start, int i) {
  if (i == numbers.length) {
    return numbers;
  }
  
  int number = (start + i);
  if (number % 3 == 0 && number % 5 == 0) {
    numbers[i] = "FizzBuzz";
  }
  else if (number % 3 == 0) {
    numbers[i] = "Fizz";
  }
  else if (number % 5 == 0) {
    numbers[i] = "Buzz";
  }
  else {
    numbers[i] = String.valueOf(number);
  }
  
  return fizzBuzz(numbers, start, i+1);
}
*/
