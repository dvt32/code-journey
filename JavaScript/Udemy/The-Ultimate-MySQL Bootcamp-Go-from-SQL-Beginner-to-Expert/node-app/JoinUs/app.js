var express = require('express');
var mysql = require('mysql2');
var bodyParser = require('body-parser');
var app = express();

app.set("view engine", "ejs");
app.use(bodyParser.urlencoded({extended: true}));
app.use(express.static(__dirname + "/public"));

var connection = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '12345',
    database: 'join_us'
});

app.get("/", function(req, res) {
    var q = "SELECT COUNT(*) AS count FROM users";
    
    connection.query(q, function(err, results) {
        if (err) throw err;
        var count = results[0].count;
        //res.send("We have " + count + " users in our db");
        res.render("home", { count: count });
    });
})

app.post("/register", function(req, res) {
    var person = {
        email: req.body.email
    }
    
    connection.query('INSERT INTO users SET ?', person, function(err, result) {
        if (err) throw err;
        res.redirect("/");
    });
})

app.get("/joke", function(req, res) {
    var joke = "<strong>What do you call a dog that does magic tricks?</strong> <em>A labracadabrador</em>.";
    res.send(joke);
})

app.get("/random_num", function(req, res) {
    var num = Math.floor(Math.random() * 10) + 1;
    res.send("Your lucky number is " + num);
});

app.listen(8080, function() {
    console.log("Server running on 8080!");
});