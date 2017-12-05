var mysql = require('mysql');

var con = mysql.createConnection({
  host: "srv.iits.uni-ruse.bg",
  user: "inf52",
  password: "inf52pass",
  database: "db52"
});

con.connect(function(err) {
  if (err) throw err;
  con.query("SELECT * FROM student11", function(err, result, fields) {
    if (err) throw err;
    console.log(result);
  });
});