package DAOApi;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Character")
public class Character{
	public static final String NAME_FIELD_NAME = "name";
	public static final String CLASS_FIELD_NAME = "class";
	public static final String PTIME_FIELD_NAME = "playTime";
	public static final String LEVEL_FIELD_NAME = "level";
	public static final String ASCE_FIELD_NAME = "ascendancy";
	
	@DatabaseField(generatedId = true)
	public int cId;
	@DatabaseField(columnName = NAME_FIELD_NAME)
    public String name;
	@DatabaseField(columnName = CLASS_FIELD_NAME)
    public String classP;
    @DatabaseField(columnName = PTIME_FIELD_NAME)
    public int playTime;
    @DatabaseField(columnName = LEVEL_FIELD_NAME)
    public int level;
    @DatabaseField(foreign=true, foreignAutoCreate = true, foreignAutoRefresh = true, columnName = ASCE_FIELD_NAME)
	public Ascendancy ascendancy;
    
    public Character(final Ascendancy setAscendancy,final String setName, final String setClass, final int setPlayTime, final int setLevel) {
    	this.ascendancy=setAscendancy;
        this.name = setName;
        this.classP = setClass;
        this.playTime = setPlayTime;
        this.level = setLevel;
    }
    
    public Character(){}
}
