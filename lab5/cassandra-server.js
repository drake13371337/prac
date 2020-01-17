var http = require("http");
var fs = require("fs");
var cassandra = require('cassandra-driver');
var client = new cassandra.Client({contactPoints: ['127.0.0.1'], localDataCenter: 'datacenter1', keyspace:'charkeyspace'});

http.createServer(function(req, res){
  console.log("Req: "+req.url);
  switch(req.url){
    case "/":
      fs.readFile("./cassandra-server.html", function(err, content){
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
        console.log(post);

        if(post[1] === "name" || post[1] === "class" || post[1] === "level" || post[1] === "playtime"){
          console.log("Correct inp");
        } else post[1] = "";

        if(post[0] === "" || post[1] === ""){
          client.execute("SELECT * FROM character", function(err, result){
            res.end(JSON.stringify(result.rows));
          });
        } else {
          var prepareq = "SELECT * FROM character WHERE "+post[1]+"=?";
          var postq=[post[0]];
          client.execute(prepareq, postq, {prepare: true}, function(err, result){
            if(err){
              console.log(err);
            } else {
              res.end(JSON.stringify(result.rows));
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
