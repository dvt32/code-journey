// https://www.freecodecamp.com/challenges/binary-agents

function binaryAgent(str) {
  var arr = str.split(" ");
  for (var i = 0; i < arr.length; ++i) {
    arr[i] = parseInt(arr[i], 2);
  }
  var output = String.fromCharCode.apply(null, arr);
  return output;
}
