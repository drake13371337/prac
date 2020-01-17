var http = require("http");
var fs = require("fs");
var mongodb = require('mongodb');
var MongoClient = mongodb.MongoClient;
var url = "mongodb://localhost:27017";



http.createServer(function(req, res){
  console.log("Req: "+req.url);
  switch(req.url){
    case "/":
      fs.readFile("./mongo-server.html", function(err, content){
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

        MongoClient.connect(url, function(err, client){
          if(err){
            console.log("Failed to connection", err);
          } else {
            console.log("Connected to ", url);

            var db = client.db("character-db");
            var collection = db.collection("character");

            if(post === ""){
              collection.find().toArray(function(err, result){
                if(err){
                  console.log(err);
                } else if (result.length>0) {
                  res.end(JSON.stringify(result));
                }
              });
            } else {
              collection.find({$or: [{name: {$regex: post}},
                                     {class: {$regex: post}},
                                     {playtime: {$regex: post}},
                                     {level: {$regex: post}}]}
              ).toArray(function(err, result){
                if(err){
                  console.log(err);
                } else if (result.length>0) {
                  res.end(JSON.stringify(result));
                }
              });
            }
          }
        });
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
