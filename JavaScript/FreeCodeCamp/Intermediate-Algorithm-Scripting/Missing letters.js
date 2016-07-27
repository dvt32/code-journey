// https://www.freecodecamp.com/challenges/missing-letters

function fearNotLetter(str) {
  var missingLetter = '';
  for (var i = 0; i < str.length-1; ++i) {
    var currentCode = str.charCodeAt(i);
    var nextCode = str.charCodeAt(i+1);
    if (nextCode !== currentCode+1) {
      missingLetter = String.fromCharCode(currentCode+1);
      return missingLetter;
    }
  }
  return undefined;
}
