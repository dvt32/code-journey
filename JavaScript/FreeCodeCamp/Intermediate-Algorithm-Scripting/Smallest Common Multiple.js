// https://www.freecodecamp.com/challenges/smallest-common-multiple

//noprotect
function smallestCommons(arr) {
  var lowEnd = Math.min(arr[0], arr[1]);
  var highEnd = Math.max(arr[0], arr[1]);
  
  for (var i = 1; ; ++i) {
    var isSmallestCommonMultiple = true;
    for (var j = lowEnd; j <= highEnd; ++j) {
      if (i % j !== 0) {
        isSmallestCommonMultiple = false;
        break;
      }
    }
    if (isSmallestCommonMultiple) {
      return i;
    }
  }
  
  return -1;
}
