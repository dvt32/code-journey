// https://www.freecodecamp.com/challenges/title-case-a-sentence

function titleCase(str) {
  str = str.split(" ");
  for (var i = 0; i < str.length; ++i) {
    str[i] = str[i].replace(str[i][0], str[i][0].toUpperCase());
    for (var j = 1; j < str[i].length; ++j) {
      str[i] = str[i].replace(str[i][j], str[i][j].toLowerCase());
    }
  }
  str = str.join(" ");
  return str;
}
