// https://www.freecodecamp.com/challenges/steamroller

function steamrollArray(arr) {
  var output = [];
  
  var flatten = function(arg) {
    if (!Array.isArray(arg)) {
      output.push(arg);
    }
    else {
      for (var i = 0; i < arg.length; ++i) {
        flatten(arg[i]);
      }
    }
  }
  
  flatten(arr);
  
  return output;
}
