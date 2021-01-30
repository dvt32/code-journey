"use strict";
var DaysOfTheWeek;
(function (DaysOfTheWeek) {
    DaysOfTheWeek[DaysOfTheWeek["SUN"] = 100] = "SUN";
    DaysOfTheWeek[DaysOfTheWeek["MON"] = 101] = "MON";
    DaysOfTheWeek[DaysOfTheWeek["TUE"] = 102] = "TUE";
    DaysOfTheWeek[DaysOfTheWeek["WED"] = 103] = "WED";
    DaysOfTheWeek[DaysOfTheWeek["THU"] = 104] = "THU";
    DaysOfTheWeek[DaysOfTheWeek["FRI"] = 105] = "FRI";
    DaysOfTheWeek[DaysOfTheWeek["SAT"] = 106] = "SAT";
})(DaysOfTheWeek || (DaysOfTheWeek = {}));
var day;
day = DaysOfTheWeek.MON;
if (day === DaysOfTheWeek.MON) {
    console.log("Got to go to work!");
}
