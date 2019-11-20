var app = angular.module("nestedControllers", []);

app.controller("Ctrl1", Ctrl1);
app.controller("Ctrl2", Ctrl2);

// When you use ControllerAs syntax, Angular does something like:
// var this = $scope;
// Note: if you DON'T use ControllerAs syntax, you need to inject $scope as an argument
function Ctrl1() {
    this.testProp = "From Ctrl1";
}
function Ctrl2() {
    this.testProp = "From Ctrl2";
}