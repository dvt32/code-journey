var mysql = require('mysql');

var con = mysql.createConnection({
  host: "srv.iits.uni-ruse.bg",
  user: "inf52",
  password: "inf52pass"
});

con.connect(function(err) {
  if (err) throw err;
  console.log("Connected!");
});