package DAOApi;

import java.util.*;
import java.sql.*;

public class CharTable
{
    private static Connection con;
    private static ResultSet rs;
    private static PreparedStatement ps;
    
    public CharTable() {
    }
    
    public CharTable(final Connection conC) {
        CharTable.con = conC;
    }
    
    public void insertChar(final List<Character> listP) throws Exception {
        for (final Character t : listP) {
            final String rec = "INSERT INTO Character VALUES(?, ?, ?, ?);";
            final PreparedStatement ps = CharTable.con.prepareStatement(rec);
            ps.setString(1, t.name);
            ps.setString(2, t.classP);
            ps.setInt(3, t.playTime);
            ps.setInt(4, t.level);
            ps.executeUpdate();
        }
    }
    
    public List<Character> getTable() throws Exception {
        final List<Character> buff = new ArrayList<Character>();
        final Statement st = CharTable.con.createStatement();
        CharTable.rs = st.executeQuery("SELECT * from Character");
        while (CharTable.rs.next()) {
            final Character charBuff = new Character();
            charBuff.name = CharTable.rs.getString("name");
            charBuff.classP = CharTable.rs.getString("class");
            charBuff.playTime = Integer.parseInt(CharTable.rs.getString("playTime"));
            charBuff.level = Integer.parseInt(CharTable.rs.getString("level"));
            buff.add(charBuff);
        }
        return buff;
    }
    
    public List<Character> getClass(final String classC) throws Exception {
        final List<Character> buff = new ArrayList<Character>();
        final String rec = "SELECT * from Character WHERE class=?";
        (CharTable.ps = CharTable.con.prepareStatement(rec)).setString(1, classC);
        CharTable.rs = CharTable.ps.executeQuery();
        while (CharTable.rs.next()) {
            final Character charBuff = new Character();
            charBuff.name = CharTable.rs.getString("name");
            charBuff.classP = CharTable.rs.getString("class");
            charBuff.playTime = Integer.parseInt(CharTable.rs.getString("playTime"));
            charBuff.level = Integer.parseInt(CharTable.rs.getString("level"));
            buff.add(charBuff);
        }
        return buff;
    }
    
    public List<Character> getTableAscendancy() throws Exception {
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
    }
}