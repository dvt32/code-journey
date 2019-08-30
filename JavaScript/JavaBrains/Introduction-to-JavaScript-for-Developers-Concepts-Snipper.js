var a = 10;
var b = 20;
var c = a+b;
var d = "Hello";
var e = true;

console.log(a);
console.log(b);
console.log(c);
console.log(d);
console.log(e);

///

a = "Hello JavaScript!";
console.log(a);

///

var f;
console.log(f); // undefined

var g = null;
console.log(null);

/// typeof

console.log("--- typeof ---")

var h;
console.log(typeof h);

h = 42;
console.log(typeof h);

h = "Hello";
console.log(typeof h);

h = true;
console.log(typeof h);

h = null;
console.log(typeof h);

// type coercion and === operator

var i = 10;
var j = "10";

if (i == j) { // does type conversion, so they are equal
    console.log("Values are equal (==)");
}

if (i === j) { // does NOT do type conversion, so they are NOT equal
    console.log("Values are equal (===)");
}

// type coercion summary

var k = undefined; // 0, null, "",  false, undefined are false, all else is true
if (k) {
    console.log("k is true");
}
else {
    console.log("k is false");
}

// objects

var myString = "Hello";
var myObj = {};
console.log(myObj);

myObj.prop = "Hello"; // create new property "prop"
console.log(myObj);

myObj.prop2 = 123;
console.log(myObj);
console.log("The number property is " + myObj.prop2);

// the object literal

var myLiteralObject = {
    "prop": "Hello",
    "prop1": 123,
    "prop3": true
};

console.log(myLiteralObject);
console.log("The number property is " + myLiteralObject.prop1);
console.log("Accessing property that doesn't exist: " + myLiteralObject.prop2);

// square bracket notation

console.log("Accessing property using square bracket notation: " + myLiteralObject["prop1"]);

// difference between dot and bracket notation

var mySpecialObject = {
    "1": "one" // terrible property name, just used as an example
} // can't access it via dot notation, so only bracket notation is available

console.log(mySpecialObject["1"]);

var myNewObject = {
    "prop": "Hello",
    "prop1": 123,
    "prop3": true
};

var propertyName = "prop1";
console.log(myNewObject[propertyName]); // use variable value as property name

// nested objects

var mySuperNewObject = {
    "prop": "Hello",
    "prop1": 123,
    "prop3": true,
    "objProp": {
        "innerProp": "Inner property"
    }
};

console.log(mySuperNewObject.objProp.innerProp);

mySuperNewObject.objProp.newInner = "New inner value";

console.log(mySuperNewObject);

console.log(mySuperNewObject.objProp["innerProp"]);

// revisiting === for objects

var myObject = {
    "myProp": "Hello"
};

var myObject2;
myObject2 = myObject;
console.log(myObject2.myProp);

if (myObject2 === myObject) { // if variables point to the same object
    console.log("Variables are equal.");
}

// delete property

var myFantasticObject = {
    "myProp": "Hi again"
}

delete myFantasticObject.myProp;

console.log(myFantasticObject);

// introcucing arrays

var myArray = ["Hello", "World", "JS"];
console.log(myArray[3]);

myArray[3] = "JavaBrains";
console.log(myArray);

// wrapper objects

var str = "hello world"; // it's a string
console.log(str.length); // converted to String to get length
console.log(typeof str); // strill string primitive, because object above has not been assigned

// introduction to functions & return values

function sayHello(name, timeOfDay) {
    return (
      'Hello ' + name + 
      ' Time of day is ' + timeOfDay
    );
}

var result = sayHello('dvt32', 'afternoon');
console.log(result);

// function expressions
var f = function foo() { // function is NOT executed
  console.log("Hello");  
};
f();

// anonymous functions
var f1 = function() {
    // ...
}

// functions as arguments
var myFunc = function(name) {
    console.log("Hello " + name);
}

var executor = function(fn, name) {
    fn(name);
}

executor(myFunc, "dvt32");

// functions on objects
var myMagicalObject = {
  "testProp": true 
};

myMagicalObject.myMethod = function() {
    console.log("Function in object");
}

myMagicalObject.myMethod();

// this keyword
var person = {
    "firstName": "Dimitar",
    "lastName": "Trifonov",
    "getFullName": function() {
        return this.firstName + " " + this.lastName;
    }
};

var fullName = person.getFullName();

var person2 = person;
person = {};

console.log(person2.getFullName());

// exercise
var person3 = {
    "firstName": "Dimitar",
    "lastName": "Trifonov",
    "getFullName": function() {
        return this.firstName + " " + this.lastName;
    },
    "address": {
        "street": "123 JS Street",
        "city": "JS",
        "state": "CA"
    },
    "isFromState": function(state) {
        return state === this.address.state;
    }
};

console.log(person3.isFromState("CA1"));

// default function arguments
var add = function(a, b) {
    console.log(arguments);
    return a + b;
}

console.log(add(10, 30, 1, 2, 3, 4));

// array methods
var myArray = [10, 20, "Hello", {}];

console.log( myArray.push(10) ); // adds new element & returns updated length of array
myArray.pop(); // delete last element
myArray.pop();
console.log( myArray );

myArray.shift(); // delete first element
console.log(myArray);
myArray.unshift("abcd"); // add element to the beginning of array
console.log(myArray);

// Array forEach methods

var myFunction = function(item) {
    console.log("For an element " + item);
}

myArray.forEach(myFunction);