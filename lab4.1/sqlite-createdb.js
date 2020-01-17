var sqlite3 = require("sqlite3").verbose();

var db = new sqlite3.Database("character.db");

db.run("CREATE TABLE Character(name TEXT, class TEXT, playTime INT, level INT)", function(err){
  if(err){
    console.log(err);
  } else {
    var stmt = db.prepare("INSERT INTO Character VALUES(?, ?, ?, ?)");
    stmt.run("Teon", "Duelist", 8, 1);
    stmt.run("Ferune", "Witch", 89, 23);
    stmt.run("Fineme", "Witch", 56, 25);
    stmt.run("Dan", "Scion", 7, 23);
    stmt.run("Gamart", "Witch", 1, 80);
    stmt.run("Zarol", "Templar", 24, 74);
    stmt.run("Anig", "Ranger", 14, 31);
    stmt.run("Thiale", "Marauder", 20, 58);
    stmt.run("Ralis", "Witch", 17, 56);
    stmt.run("Nizan", "Scion", 14, 61);
    stmt.run("Prinl", "Ranger", 8, 80);
    stmt.run("Onnedebri", "Ranger", 9, 2);
    stmt.run("Xunth", "Templar", 18, 10);
    stmt.run("Veraro", "Shadow", 21, 58);
    stmt.run("Wagonncrw", "Witch", 45, 61);
    stmt.run("Zedieytia", "Duelist", 96, 40);
    stmt.run("Iar", "Templar", 75, 79);
    stmt.run("TerYrkahai", "Witch", 66, 68);
    stmt.run("Var", "Duelist", 51, 80);
    stmt.run("Maloruig", "Shadow", 11, 1);
    stmt.finalize();
    console.log("Created character.db")
  }
  db.close();
});
