package DAOApi;

import java.util.*;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.*;

public class CharTable
{
    private static ConnectionSource con;
    private Dao<Character, String> charDao;
    
    public CharTable() {
    }
    
    public CharTable(final ConnectionSource conC) throws Exception {
        CharTable.con = conC;
        charDao = DaoManager.createDao(con, Character.class);
    }
    
    public void insertChar(final List<Character> listP) throws Exception {
        for (final Character t : listP) {
            charDao.create(t);
        }
    }
    
    public List<Character> getTable() throws Exception {
        final List<Character> buff = charDao.queryForAll();
        return buff;
    }
    
    public List<Character> getClass(final String classC) throws Exception {
        final List<Character> buff = charDao.queryBuilder().where().in("class", classC).query();
        return buff;
    }
    
    /*public List<Character> getTableAscendancy() throws Exception {
        final List<Character> buff = new ArrayList<Character>();
        final Statement st = CharTable.con.createStatement();
        CharTable.rs = st.executeQuery("SELECT * from Character INNER JOIN Ascendancy ON Character.name=Ascendancy.namea");
        while (CharTable.rs.next()) {
            final Character charBuff = new Character();
            charBuff.name = CharTable.rs.getString("name");
            charBuff.classP = CharTable.rs.getString("class");
            charBuff.playTime = Integer.parseInt(CharTable.rs.getString("playTime"));
            charBuff.level = Integer.parseInt(CharTable.rs.getString("level"));
            charBuff.ascendancyClass = CharTable.rs.getString("ascendancyClass");
            buff.add(charBuff);
        }
        return buff;
    }
    
    public List<Character> getTableAscendancyClass(final String classP) throws Exception {
        final List<Character> buff = new ArrayList<Character>();
        final String rec = "SELECT * from Character INNER JOIN Ascendancy ON Character.name=Ascendancy.namea AND Ascendancy.ascendancyClass=?";
        (CharTable.ps = CharTable.con.prepareStatement(rec)).setString(1, classP);
        CharTable.rs = CharTable.ps.executeQuery();
        while (CharTable.rs.next()) {
            final Character charBuff = new Character();
            charBuff.name = CharTable.rs.getString("name");
            charBuff.classP = CharTable.rs.getString("class");
            charBuff.playTime = Integer.parseInt(CharTable.rs.getString("playTime"));
            charBuff.level = Integer.parseInt(CharTable.rs.getString("level"));
            charBuff.ascendancyClass = CharTable.rs.getString("ascendancyClass");
            buff.add(charBuff);
        }
        return buff;
    }*/
}