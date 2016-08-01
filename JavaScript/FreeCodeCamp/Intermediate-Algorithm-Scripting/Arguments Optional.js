// https://www.freecodecamp.com/challenges/arguments-optional

function addTogether() {
  if (arguments.length === 1) {
     var firstArgument = arguments[0];
     if (typeof firstArgument !== 'number') {
         return undefined;
     }
     var fun = function(arg) {
       if (typeof arg !== 'number') {
         return undefined;
       }
       else {
         return firstArgument + arg; 
       }
     };
     return fun;
  } 
  else {
    var sum = 0;
    for (var i = 0; i < arguments.length; ++i) {
      if (typeof arguments[i] !== 'number') {
        return undefined;
      }
      else {
        sum += arguments[i];
      }
    }
    return sum;
  }
}
