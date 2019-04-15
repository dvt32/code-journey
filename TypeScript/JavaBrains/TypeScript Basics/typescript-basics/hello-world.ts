/*

var a: number;
var b: boolean;
var c: string;
a = 10;
b = true;
c = 'Hello';

//

var myArr : number[];
myArr = [];
myArr = [1, 2];
myArr.push(3);
a = myArr.pop();

//

var myTuple : [number, boolean];
myTuple = [1, true];

//

function add(a: number, b: number, c = 0, d: number = 0) : number {
    return a + b + c;
}

var sum = add(1, 2, 3);
console.log(sum);

//

var a = 10;
var b = true;
var c = "Hello";

function greet() : string {
    return "Good morning";
}
var greeting = greet();

//

var anyTypeVar : any;

anyTypeVar = 10;
anyTypeVar = true;
anyTypeVar = "String";

//

*/

var unionTypeVar : number | boolean | string;
unionTypeVar = 10;
unionTypeVar = true;
unionTypeVar = 'a';