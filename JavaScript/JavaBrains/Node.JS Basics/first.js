// var operatorsObj = require('./add.js');

var { add } = require('./add.js');

function greet(name) {
    console.log("Hello there, " + name + "!");
}

greet("dvt32");

// operatorsObj.add(10, 20);

console.log(add(10, 20));