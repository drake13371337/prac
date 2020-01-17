var http = require("http");
var fs = require("fs");
var sqlite3 = require("sqlite3").verbose();
var db = new sqlite3.Database("character.db");

http.createServer(function(req, res){
  console.log("Req: "+req.url);
  switch(req.url){
    case "/":
      fs.readFile("./ajax-server.html", function(err, content){
        if(!err){
          res.writeHead(200, {"Content-Type": "text/html; charset=utf-8"});
          res.end(content, "utf-8");
        } else {
          res.writeHead(200, {"Content-Type": "text/html; charset=utf-8"});
          res.end(content, "utf-8");
          console.log(err);
        }
      });
      break;
    case "/search":
      var jsonpost='';
      var post;

      res.writeHead(200, {"Content-Type": "application/json"});

      req.on('data', function(data){
        jsonpost+=data;
      });

      req.on('end', function(){
        post=JSON.parse(jsonpost);
        if(post === ""){
          db.all("SELECT * FROM character", function(err, row){
            res.end(JSON.stringify(row));
          });
        } else {
          postq=[post, post, post, post];
          var stmt = db.prepare("SELECT * FROM character WHERE (name LIKE ('%' || ? || '%')) or (class LIKE ('%' || ? || '%')) or (playTime LIKE ('%' || ? || '%')) or (level LIKE ('%' || ? || '%'))");
          stmt.all(postq, function(err, row){
            if(err){
              console.log(err);
            } else {
              res.end(JSON.stringify(row));
            }
          });
        }
      });
      break;

    default:
      res.writeHead(404, {"Content-Type": "text/html; charset=utf-8"});
      res.write(
        "<!DOCTYPE html>\n"+
        "<html>\n" +
        " <head>\n" +
        "  <meta charset='utf-8'>\n" +
        " </head>\n" +
        "<body>\n"
      );
      res.write("404, Not found: "+req.url);
      res.end(
        "</body>\n" +
        "</html>\n"
      );
  }
}).listen(3000);
