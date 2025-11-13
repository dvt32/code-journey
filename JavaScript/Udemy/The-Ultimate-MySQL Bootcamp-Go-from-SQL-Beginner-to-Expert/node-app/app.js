var { faker } = require('@faker-js/faker');
var mysql = require('mysql2');

var connection = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '12345',
    database: 'join_us'
});

var data = [];

for (var i = 0; i < 500; ++i) {
    data.push([
        faker.internet.email(),
        faker.date.past()
    ]);
}

var q = 'INSERT INTO users (email, created_at) VALUES ?';

connection.query(q, [data], function (err, result) {
    console.log(err);
    console.log(result);
});

connection.end();