// https://www.freecodecamp.com/challenges/sum-all-primes

function sumPrimes(num) {
  var sum = 0;
  for (var currentNumber = 2; currentNumber <= num; ++currentNumber) {
    var isPrime = true;
    for (var j = 2; j < currentNumber; ++j) {
      if (currentNumber % j === 0 ) {
        isPrime = false;
        break;
      }
    }
    if (isPrime) {
      sum += currentNumber;
    }
  }
  return sum;
}
