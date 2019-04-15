"use strict";
var __importStar = (this && this.__importStar) || function (mod) {
    if (mod && mod.__esModule) return mod;
    var result = {};
    if (mod != null) for (var k in mod) if (Object.hasOwnProperty.call(mod, k)) result[k] = mod[k];
    result["default"] = mod;
    return result;
};
Object.defineProperty(exports, "__esModule", { value: true });
var person_1 = require("./person");
var _ = __importStar(require("lodash"));
var foo = new person_1.Person('Test', 'LastName');
console.log(foo);
var array = [1, 2, 3, 4, 5];
console.log(_.reverse(array));
