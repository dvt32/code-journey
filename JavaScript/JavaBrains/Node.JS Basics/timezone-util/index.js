const moment = require('moment-timezone');

moment.tz.setDefault("Europe/Sofia");

let targetTimezone;

if (process.argv.length != 3) {
    console.log("Usage: node <script-file> <time-zone>");
    process.exit(1);
}
else {
    targetTimezone = process.argv[2];
}

console.log(`The time in ${targetTimezone} is ${moment().tz(targetTimezone).format()}`);