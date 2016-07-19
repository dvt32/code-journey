// https://www.freecodecamp.com/challenges/reverse-a-string

function reverseString(str) {
  var arr = str.split('');
  str = arr.reverse().join('');
  return str;
}
