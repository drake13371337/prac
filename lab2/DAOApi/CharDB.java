package DAOApi;
import java.sql.*;

public class CharDB{
	public static Connection con;
	public static Statement st;
	
	public CharDB() {}
	public void connect() throws Exception{
		Class.forName("org.h2.Driver").newInstance();
		con = DriverManager.getConnection("jdbc:h2:file:./Character.db");
		st = con.createStatement();
	}
	public void create() throws Exception{
		st.execute("CREATE TABLE Character(name CHAR(15), class CHAR(15), playTime INT, level INT);");
	}
}
