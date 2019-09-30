package DAOApi;

import java.sql.*;
import java.util.*;

public class AsceTable
{
    private static Connection con;
    private static PreparedStatement ps;
    
    public AsceTable() {
    }
    
    public AsceTable(final Connection conC) {
        AsceTable.con = conC;
    }
    
    public void insertChar(final List<Ascendancy> listP) throws Exception {
        for (final Ascendancy t : listP) {
            final String rec = "INSERT INTO Ascendancy VALUES(?, ?);";
            (AsceTable.ps = AsceTable.con.prepareStatement(rec)).setString(1, t.name);
            AsceTable.ps.setString(2, t.ascendancyClass);
            AsceTable.ps.executeUpdate();
        }
    }
}