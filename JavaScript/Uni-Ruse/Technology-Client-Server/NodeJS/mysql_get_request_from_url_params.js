var http = require('http');
var url = require('url');
var mysql = require('mysql');

var con = mysql.createConnection({
  host: "srv.iits.uni-ruse.bg",
  user: "inf52",
  password: "inf52pass",
  database: "db52"
});

http.createServer(function (req, res) {
  var params = url.parse(req.url, true).query;
  con.connect(function(err) {
    if (err) throw err;
    con.query("SELECT * FROM Employees wHERE ID=" + params.id, function(err, result, fields) {
      if (err) throw err;
      console.log(result);
    });
  });
}).listen(1337);




