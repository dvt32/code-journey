// https://www.freecodecamp.com/challenges/wherefore-art-thou

function whatIsInAName(collection, source) {
  var arr = new Set();
  var sourceKeys = Object.keys(source);
  
  for (var i = 0; i < collection.length; ++i) {
    var collectionKeys = Object.keys(collection[i]);
    for (var j = 0; j < sourceKeys.length; ++j) {
      if (collection[i].hasOwnProperty(sourceKeys[j]) &&
          collectionKeys.length >= sourceKeys.length &&
          collection[i][sourceKeys[j]] === source[sourceKeys[j]]) 
      {
        arr.add(collection[i]);
      }
      else if (arr.has(collection[i])) {
        arr.delete(collection[i]);
      }
    }
  }

  return Array.from(arr);
}
