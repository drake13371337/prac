var http = require("http");
var fs = require("fs");

var neo4j = require("neo4j-driver");

var uri = "bolt://localhost";
var user = "neo4j";
var password = "misha";

http.createServer(function(req, res){
  console.log("Req: "+req.url);
  switch(req.url){
    case "/":
      fs.readFile("./neo4j-server.html", function(err, content){
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

      var driver = neo4j.driver(uri, neo4j.auth.basic(user, password));

      var session = driver.session();

      res.writeHead(200, {"Content-Type": "application/json"});

      req.on('data', function(data){
        jsonpost+=data;
      });

      req.on('end', function(){
        post=JSON.parse(jsonpost);

        var que = "";

        if(post === ""){
          que="MATCH (n:Account) RETURN n LIMIT 20;";
          session.run(que).then(result => {
            session.close();
            console.log("Result records get: "+result.records.length);
            var str = new Array(result.records.length);
            for(var i=0; i<result.records.length; i++){
                var node = result.records[i].get("n").properties;
                console.log(node);
                str[i]=node;
            }
            res.end(JSON.stringify(str));
            driver.close();
          });
        }  else {
          que="MATCH (n:Account) WHERE n.name =~ $posts OR n.level =~ $posts OR n.class =~ $posts OR n.playedtime =~ $posts RETURN n LIMIT 20;";
          session.run(que, {"posts": ".*"+post+".*"}).then(result => {
            session.close();
            console.log("Result records get: "+result.records.length);
            var str = new Array(result.records.length);
            for(var i=0; i<result.records.length; i++){
                var node = result.records[i].get("n").properties;
                console.log(node);
                str[i]=node;
            }
            res.end(JSON.stringify(str));
            driver.close();
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
