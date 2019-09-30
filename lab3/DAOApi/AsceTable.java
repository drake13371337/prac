package DAOApi;

import java.util.*;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

public class AsceTable
{
    private static ConnectionSource con;
    private Dao<Ascendancy, String> asceDao;
    
    public AsceTable() {
    }
    
    public AsceTable(final ConnectionSource conC) throws Exception {
        AsceTable.con = conC;
        asceDao = DaoManager.createDao(con, Ascendancy.class);
    }
    
    public void insertChar(final List<Ascendancy> listP) throws Exception {
        for (final Ascendancy t : listP) {
            asceDao.create(t);
        }
    }
}