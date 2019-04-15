"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var Person = /** @class */ (function () {
    function Person(firstName, lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    Person.prototype.getFullName = function () {
        return this.firstName + " " + this.lastName;
    };
    return Person;
}());
exports.Person = Person;
var aPerson = new Person("Dimitar", "Trifonov");
console.log(aPerson.getFullName());
/*
class Person {
    constructor(protected firstName: string, protected lastName: string) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    greet() {
        console.log("Hey there!");
    }

    getFirstName() {
        return this.firstName;
    }

    setFirstName(firstName: string) {
        this.firstName = firstName;
    }

    getLastName() {
        return this.lastName;
    }

    setLastName(lastName: string) {
        this.lastName = lastName;
    }

    getFullName() {
        return this.firstName + this.lastName;
    }
}

class Programmer extends Person {
    greet() {
        console.log("Hello world");
    }

    greetLikeNormalPeople() {
        super.greet();
    }
}

var aProgrammer: Person = new Programmer("Dimitar", "Trifonov");
aProgrammer.greet();
aProgrammer.getFullName();
*/
/*
class Person {
    constructor(readonly name: string) {
        this.name = name;
    }
}

var aPerson = new Person("dvt32");
console.log(aPerson.name);
*/ 
