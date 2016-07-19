// https://www.freecodecamp.com/challenges/find-the-longest-word-in-a-string

function findLongestWord(str) {
  var str = str.split(" ");
  var maxLength = 0;
  for (var i = 0; i < str.length; ++i) {
    if (str[i].length > maxLength) {
      maxLength = str[i].length;
    }
  }
  return maxLength;
}
