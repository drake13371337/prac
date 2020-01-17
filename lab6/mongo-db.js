var mongodb = require('mongodb');
var MongoClient = mongodb.MongoClient;
var url = "mongodb://localhost:27017";

MongoClient.connect(url, function(err, client){
  if(!err){
    var db = client.db("character-db");
    var collection = db.collection("character");

    var character = [
      {name: "Teon", class: "Duelist", level: "1", playtime: "8"},
      {name: "Ferune", class: "Witch", level: "23", playtime: "89"},
      {name: "Fineme", class: "Witch", level: "25", playtime: "56"},
      {name: "Dan", class: "Scion", level: "23", playtime: "7"},
      {name: "Gamart", class: "Witch", level: "80", playtime: "1"},
      {name: "Zarol", class: "Templar", level: "74", playtime: "24"},
      {name: "Anig", class: "Ranger", level: "31", playtime: "14"},
      {name: "Thiale", class: "Marauder", level: "58", playtime: "20"},
      {name: "Ralis", class: "Witch", level: "56", playtime: "17"},
      {name: "Nizan", class: "Scion", level: "61", playtime: "14"},
      {name: "Prinl", class: "Ranger", level: "80", playtime: "8"},
      {name: "Onnedebri", class: "Ranger", level: "2", playtime: "9"},
      {name: "Xunth", class: "Templar", level: "10", playtime: "18"},
      {name: "Veraro", class: "Shadow", level: "58", playtime: "21"},
      {name: "Wagonncrw", class: "Witch", level: "61", playtime: "45"},
      {name: "Zedieytia", class: "Duelist", level: "40", playtime: "96"},
      {name: "Iar", class: "Templar", level: "79", playtime: "75"},
      {name: "TerYrkahai", class: "Witch", level: "68", playtime: "66"},
      {name: "Var", class: "Duelist", level: "80", playtime: "51"},
      {name: "Maloruig", class: "Shadow", level: "1", playtime: "11"}
    ];

    collection.insertMany(character, function(err, result){
      if(err){
        console.log(err);
      } else {
        console.log('Inserted', result.result.n);
      }

      console.log("DONE: close db connection");
      client.close();
    });
  }
});
