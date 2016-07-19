// https://www.freecodecamp.com/challenges/sum-all-numbers-in-a-range

var start = Math.min(arr[0], arr[1]) + 1;
var end = Math.max(arr[0], arr[1]) - 1;
  
var total = arr.reduce(function (a, b) {
  return a + b;
}, 0);
  
for (var i = start; i <= end; ++i) {
  total += i;
}
return total;
