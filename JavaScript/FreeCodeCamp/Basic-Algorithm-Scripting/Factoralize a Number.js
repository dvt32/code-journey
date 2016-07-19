// https://www.freecodecamp.com/challenges/factorialize-a-number

function factorialize(num) {
  if (num === 0) {
    return 1;
  }
  for (var i = num-1; i > 0; --i) {
    num *= i;
  }
  return num;
}
