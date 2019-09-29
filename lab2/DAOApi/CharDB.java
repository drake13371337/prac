package DAOApi;

import java.sql.*;

public class CharDB
{
    private static Connection con;
    public CharTable table;
    public AsceTable tableA;
    
    public void connect() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        CharDB.con = DriverManager.getConnection("jdbc:h2:file:./Character.db");
        this.table = new CharTable(CharDB.con);
        this.tableA = new AsceTable(CharDB.con);
    }
    
    public void create() throws Exception {
        final Statement st = CharDB.con.createStatement();
        st.execute("CREATE TABLE Character(name CHAR(15), class CHAR(15), playTime INT, level INT);");
        st.execute("CREATE TABLE Ascendancy (nameA CHAR(15), ascendancyClass CHAR(15), FOREIGN KEY (nameA) REFERENCES Character(name));");
    }
}