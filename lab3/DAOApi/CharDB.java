package DAOApi;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class CharDB
{
    private JdbcConnectionSource con;
    public CharTable table;
    public AsceTable tableA;
    
    public void connect() throws Exception {
    	con = new JdbcConnectionSource("jdbc:h2:file:./Character.db");
        this.tableA = new AsceTable(con);
        this.table = new CharTable(con, tableA.getAsceDao());
    }
    
    public void disconnect() throws Exception {
    	con.close();
    }
    
    public void create() throws Exception {
        TableUtils.createTable(con, Character.class);
        TableUtils.createTable(con, Ascendancy.class);
    }
}