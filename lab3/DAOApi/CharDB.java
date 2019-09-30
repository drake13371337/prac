package DAOApi;

import java.sql.*;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class CharDB
{
    private static ConnectionSource con;
    public CharTable table;
    public AsceTable tableA;
    
    public void connect() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        con = new JdbcConnectionSource("jdbc:h2:file:./Character.db");
        this.table = new CharTable(CharDB.con);
        this.tableA = new AsceTable(CharDB.con);
    }
    
    public void create() throws Exception {
        TableUtils.createTable(con, Character.class);
        TableUtils.createTable(con, Ascendancy.class);
    }
}