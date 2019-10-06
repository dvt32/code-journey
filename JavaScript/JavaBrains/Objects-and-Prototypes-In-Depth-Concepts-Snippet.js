// Objects and Prototypes In-depth - notes

/*
3. Creating objects
*/

var emp1 = {};
emp1.firstName = "Michael";
emp1.lastName = "Scott";
emp1.gender = "M";
emp1.designation = "Regional Manager";

var emp2 = {};
emp2.firstName = "Dwight";
emp2.lastName = "Schrute";
emp2.gender = "M";
emp2.designation = "Assistant to the Regional Manager";

function createEmployeeObject(
   firstName, lastName, gender, designation) 
{
    var newObject = {};
    newObject.firstName = firstName;
    newObject.lastName = lastName;
    newObject.gender = gender;
    newObject.designation = designation;
    return newObject;
}

var emp3 = createEmployeeObject(
    "Jim", "Halpert", "M", "Sales Representative"
);

/*
4. JavaScript constructors
*/

function createEmployeeObjectWithConstructor(
   firstName, lastName, gender, designation) 
{
    // var this = {};
    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
    this.designation = designation;
    // return this;
}

var emp4 = new createEmployeeObjectWithConstructor(
    "Jim", "Halpert", "M", "Sales Representative"
);

console.log(emp4);

/*
5. Difference between regular functions and constructors
*/

var bicycle1 = createBicycle(50, 20, 4);
var bicycle2 = createBicycle(20, 5, 1);

function createBicycle(cadence, speed, gear) {
    var newBicycle = {}
    newBicycle.cadence = cadence;
    newBicycle.speed = speed;
    newBicycle.gear = gear;
    return newBicycle;
}

function BicycleObj(cadence, speed, gear) {
    this.cadence = cadence;
    this.speed = speed;
    this.gear = gear;
}

var bicycle4 = new BicycleObj(50, 20, 4);

/*
7. Function Execution Types
*/

// Method #1
function foo() {
    console.log("Hello");
}
foo();

// Method #2
var obj = {};
obj.foo = function() {
    console.log("Hello");
}
obj.foo();

// Method #3
new foo();

// Method 4
foo.call();

/*
10. Using the call function
*/

function Bicycle(cadence, speed, gear, tirePressure) {
    this.cadence = cadence;
    this.speed = speed;
    this.gear = gear;
    this.tirePressure = tirePressure;
    this.inflateTires = function() {
        this.tirePressure += 3;
    }
}

var firstBicycle = new Bicycle(50, 20, 4, 25);
firstBicycle.inflateTires();
var secondBicycle = new Bicycle(50, 20, 4, 30);
secondBicycle.inflateTires();

function Mechanic() {
    this.name = name;
}

var mike = new Mechanic("Mike");
mike.inflateTires = firstBicycle.inflateTires;
mike.inflateTires.call(firstBicycle);

/*
14. Object behaviors using prototypes
*/

function EmployeeAtOffice(name) {
    this.name = name;
}

var employee1 = new EmployeeAtOffice("Jim");
var employee2 = new EmployeeAtOffice("Pam");
EmployeeAtOffice.prototype.playPranks = function() { 
    console.log("Prank played!");
}

employee1.playPranks();
employee2.playPranks();