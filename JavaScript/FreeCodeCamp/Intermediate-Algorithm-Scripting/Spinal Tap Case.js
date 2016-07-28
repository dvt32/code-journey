// https://www.freecodecamp.com/challenges/spinal-tap-case

function spinalCase(str) {
  var regExp = new RegExp(/[ _]/g);
  var capitalLetters = new RegExp(/[A-Z]/g);
  
  str = str.replace(regExp, "-");
  var output = "";
  
  output += str[0].toLowerCase();
  for (var i = 1; i < str.length; ++i) {
    if (capitalLetters.test(str[i]) &&
        str[i-1] !== "-") 
    {
      output += "-" + str[i].toLowerCase();
    }
    else 
    {
      output += str[i].toLowerCase();
    }
  }
  
  return output;
}
