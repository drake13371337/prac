var neo4j = require("neo4j-driver");

var uri = "bolt://localhost";
var user = "neo4j";
var password = "misha";

var driver = neo4j.driver(uri, neo4j.auth.basic(user, password));
var session = driver.session();

session.run(
  "CREATE (Teon:Account{name: 'Teon', class: 'Duelist', level: '1', playtime: '8'})"+
  "CREATE (Ferune:Account{name: 'Ferune', class: 'Witch', level: '23', playtime: '89'})"+
  "CREATE (Fineme:Account{name: 'Fineme', class: 'Witch', level: '25', playtime: '56'})"+
  "CREATE (Dan:Account{name: 'Dan', class: 'Scion', level: '23', playtime: '7'})"+
  "CREATE (Gamart:Account{name: 'Gamart', class: 'Witch', level: '80', playtime: '1'})"+
  "CREATE (Zarol:Account{name: 'Zarol', class: 'Templar', level: '74', playtime: '24'})"+
  "CREATE (Anig:Account{name: 'Anig', class: 'Ranger', level: '31', playtime: '14'})"+
  "CREATE (Thiale:Account{name: 'Thiale', class: 'Marauder', level: '58', playtime: '20'})"+
  "CREATE (Ralis:Account{name: 'Ralis', class: 'Witch', level: '56', playtime: '17'})"+
  "CREATE (Nizan:Account{name: 'Nizan', class: 'Scion', level: '61', playtime: '14'})"+
  "CREATE (Prinl:Account{name: 'Prinl', class: 'Ranger', level: '80', playtime: '8'})"+
  "CREATE (Onnedebri:Account{name: 'Onnedebri', class: 'Ranger', level: '2', playtime: '9'})"+
  "CREATE (Xunth:Account{name: 'Xunth', class: 'Templar', level: '10', playtime: '18'})"+
  "CREATE (Veraro:Account{name: 'Veraro', class: 'Shadow', level: '58', playtime: '21'})"+
  "CREATE (Wagonncrw:Account{name: 'Wagonncrw', class: 'Witch', level: '61', playtime: '45'})"+
  "CREATE (Zedieytia:Account{name: 'Zedieytia', class: 'Duelist', level: '40', playtime: '96'})"+
  "CREATE (Iar:Account{name: 'Iar', class: 'Templar', level: '79', playtime: '75'})"+
  "CREATE (TerYrkahai:Account{name: 'TerYrkahai', class: 'Witch', level: '68', playtime: '66'})"+
  "CREATE (Var:Account{name: 'Var', class: 'Duelist', level: '80', playtime: '51'})"+
  "CREATE (Maloruig:Account{name: 'Maloruig', class: 'Shadow', level: '1', playtime: '11'})"
).then(result => {
  session.close();
  driver.close();
});
