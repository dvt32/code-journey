// function add(a, b) {
//     return a + b;
// }

// function subtract(a, b) {
//     return a - b;
// }

// console.log( add(1, 2) );

// module.exports = add;

// module.exports = {
//     add,
//     subtract
// };

// module.exports = {
//     add: add,
//     subtract: subtract
// };

// module.exports.add = add;
// module.exports.subtract = subtract;

// exports.add = add;
// exports.subtract = subtract;
// NOTE: Do NOT use 'exports = add;', as this will assign a new value to 'exports'

exports.add = (a, b) => a+b;