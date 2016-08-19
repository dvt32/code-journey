// http://www.codeabbey.com/index/task_view/sum-of-digits

var getSumOfDigits = function(number) {
	var sumOfDigits = 0;
	while (number !== 0) {
		var currentDigit = number % 10;
		sumOfDigits += currentDigit;
		number /= 10;
		number = parseInt(number);
	}
	return sumOfDigits;
};

var numberOfTestcases = prompt();
var allSums = "";

for (var i = 0; i < numberOfTestcases; ++i) {
	var numbers = prompt().split(' ');
	var a = parseInt(numbers[0]);
	var b = parseInt(numbers[1]);
	var c = parseInt(numbers[2]);
	var finalNumber = a * b + c;
	var sumOfDigits = getSumOfDigits(finalNumber);
	allSums += sumOfDigits + " ";
}

console.log(allSums);
