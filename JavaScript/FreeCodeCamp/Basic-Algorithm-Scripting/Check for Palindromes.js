// https://www.freecodecamp.com/challenges/check-for-palindromes

function palindrome(str) {
  str = str.replace(/[\W_]/g, '').toLowerCase();
  for (var i = 0, j = str.length - 1; i < j; ++i, --j) {
    if (str[i] !== str[j]) {
      return false;
    }
  }
  return true;
}
