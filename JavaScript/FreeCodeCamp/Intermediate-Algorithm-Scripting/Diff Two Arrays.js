// https://www.freecodecamp.com/challenges/diff-two-arrays

function diffArray(arr1, arr2) {
  var concatArr = arr1.concat(arr2);
  var outputArr = [];
  
  for (var i = 0; i < concatArr.length; ++i) {
    if (arr1.indexOf(concatArr[i]) === -1 ||
        arr2.indexOf(concatArr[i]) === -1)
     {
       outputArr.push(concatArr[i]);
     }
  }
  
  return outputArr;
}
