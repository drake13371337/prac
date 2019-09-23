package DAOApi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AsceDB {
	public static Connection con;
	public static Statement st;
	
	public AsceDB() {}
	public void connect() throws Exception{
		Class.forName("org.h2.Driver").newInstance();
		con = DriverManager.getConnection("jdbc:h2:file:./Character.db");
		st = con.createStatement();
	}
	public void create() throws Exception{
		st.execute("CREATE TABLE Ascendancy (nameA CHAR(15), ascendancyClass CHAR(15), FOREIGN KEY (nameA) REFERENCES Character(name));");
	}
}
