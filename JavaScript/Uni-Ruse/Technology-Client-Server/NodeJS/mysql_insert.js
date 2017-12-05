var mysql = require('mysql');

var con = mysql.createConnection({
  host: "srv.iits.uni-ruse.bg",
  user: "inf52",
  password: "inf52pass",
  database: "db52"
});

con.connect(function(err) {
  if (err) throw err;
  console.log("Connected!");
  var sql = "INSERT INTO Employees (id, first, last, age) VALUES (1, 'Some', 'Guy', 22)";
  con.query(sql, function(err, result) {
    if (err) throw err;
    console.log("1 record inserted");
  });
});