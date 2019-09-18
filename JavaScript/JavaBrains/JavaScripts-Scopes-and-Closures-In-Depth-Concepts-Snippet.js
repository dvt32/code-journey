// Scopes and Closures In-Depth - notes

/*
 6 - IIFE
*/

// directly call anonymous function
(function() {
    var a = 10;
    var b = 10;
    console.log(a + b);
})();

/*
9 - The window object
*/

// now Window object will have 'abc' & 'def' properties
// and 'myFunc' function
var abc = 1;
var def = 'HI';
function myFunc() { console.log("hii") } 

/*
13 - The Global scope problem
*/

var a = 10;

function myFn() {
    var b = a;
    console.log(b);
    // console.log(c); // throws error
    c = 100; // creates variable in global scope
}

/*
16. Strict mode
*/
function myCode() {
    //"use strict";
    var myName = "dvt32";
    myname = "oops"; // throws error with strict mode enabled
}

myCode();

/*
19. Closures In Callbacks
*/

var myVar = 10;

var fn = function() {
    console.log(myVar);
}

// thanks to closures, 
// setTimeout() can access the value of 'myVar'
setTimeout(fn, 3000);
console.log("Done!")

/*
20. The Module Pattern
*/

// Use closures to mimic private fields

function createPerson() {
    var firstName = "Dimitar";
    var lastName = "Trifonov";
    
    var returnObj = {
        "getFirstName": function() {
            return firstName;
        },
        "getLastName": function() {
            return lastName;
        },
        "setFirstName": function(name) {
            firstName = name;
        },
        "setLastName": function(name) {
            lastName = name;
        }
    }

    return returnObj;
}

var person = createPerson();

console.log(person.getFirstName());
person.setFirstName("dvt32");
console.log(person.getFirstName());

/*
22. Solving async with closures
*/

var i;
for (i = 0; i < 10; i++) {
    (function() {
        var currentValueOfI = i;
        setTimeout(function() {
            console.log(currentValueOfI);
        }, 1000);
    })();
}