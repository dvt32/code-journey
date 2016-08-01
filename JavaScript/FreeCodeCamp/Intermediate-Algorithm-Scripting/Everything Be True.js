// https://www.freecodecamp.com/challenges/everything-be-true

function truthCheck(collection, pre) {
  var isFalsy = function(arg) {
    return arg === undefined ||
           arg === null ||
           arg !== arg ||
           arg === 0 ||
           arg === "" ||
           arg === false;
  };
  
  var numberOfTruthyObjects  = 0;
  
  collection.forEach(function(object) {
    // Alternatively check if Boolean(object[pre]) evaluates to true
    if (object.hasOwnProperty(pre) && !isFalsy(object[pre])) {
      numberOfTruthyObjects++;
    }
  });
  
  return numberOfTruthyObjects === collection.length;
}
