// https://www.freecodecamp.com/challenges/pig-latin

function translatePigLatin(str) {
  var vowels = "aeiou".split("");
  var output = "";
  var index = 0;
  
  if (vowels.indexOf(str.charAt(index)) !== -1) {
      output = str + "way";
      return output;
  }
  else {
    while (vowels.indexOf(str.charAt(index)) === -1) {
      index++;
    }
    for (var i = index; i < str.length; ++i) {
      output += str.charAt(i);
    }
    for (var i = 0; i < index; ++i) {
      output += str.charAt(i);
    }
    output += "ay";
  }

  return output;
}
