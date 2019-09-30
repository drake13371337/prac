package DAOApi;

import java.util.*;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;

public class AsceTable
{
    private JdbcConnectionSource con;
    private Dao<Ascendancy, Integer> asceDao;
    
    public Dao<Ascendancy, Integer> getAsceDao() {
		return asceDao;
	}

	public AsceTable() {
    }
    
    public AsceTable(final JdbcConnectionSource conC) throws Exception {
        con = conC;
        asceDao = DaoManager.createDao(con, Ascendancy.class);
    }
    
    public void insertChar(final List<Ascendancy> listP) throws Exception {
        for (final Ascendancy t : listP) {
            asceDao.create(t);
        }
    }
}