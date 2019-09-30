package DAOApi;

import java.util.*;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.QueryBuilder;

public class CharTable
{
    private JdbcConnectionSource con;
    private Dao<Character, Integer> charDao;
    private Dao<Ascendancy, Integer> asceDao;
    
    public CharTable() {
    }
    
    public CharTable(final JdbcConnectionSource conC, Dao<Ascendancy, Integer> aDao) throws Exception {
        con = conC;
        asceDao = aDao;
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
    
    
    public List<Character> getTableAscendancyClass(final String classP) throws Exception {
    	QueryBuilder<Character, Integer> chQ = charDao.queryBuilder();
    	QueryBuilder<Ascendancy, Integer> asQ = asceDao.queryBuilder();
    	asQ.where().in("ascendancyClass", classP);
    	final List<Character> buff = chQ.join(asQ).query();
        return buff;
    }
}