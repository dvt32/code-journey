// https://www.freecodecamp.com/challenges/finders-keepers

function findElement(arr, func) {
  if (arr.length !== 0) {
    arr = arr.filter(func);
    return arr[0];
  }
  else return undefined;
}
