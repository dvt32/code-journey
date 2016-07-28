// https://www.freecodecamp.com/challenges/sum-all-odd-fibonacci-numbers

function sumFibs(num) {
  var sum = 0;
  var f1 = 0, f2 = 1;
  var new_fib = f1 + f2;
  while (new_fib <= num) {
    if (new_fib % 2 !== 0) {
      sum += new_fib;
    }
    new_fib = f1 + f2;
    f1 = f2;
    f2 = new_fib;
  }
  return sum;
}
