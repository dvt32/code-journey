// https://www.freecodecamp.com/challenges/sorted-union

function uniteUnique(arr) {
  var mySet = new Set();
  var args = Array.from(arguments);
  
  for (var i = 0; i < args.length; ++i) {
    for (var j = 0; j < args[i].length; ++j) {
      mySet.add(arguments[i][j]);
    }
  }
  
  return Array.from(mySet);
}
