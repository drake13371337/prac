package DAOApi;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Character")
public class Character{
	public static final String CLASS_FIELD_NAME = "class";
	public static final String PTIME_FIELD_NAME = "playTime";
	public static final String LEVEL_FIELD_NAME = "level";
	
	@DatabaseField(generatedId = true)
    public String name;
	@DatabaseField(columnName = CLASS_FIELD_NAME)
    public String classP;
    public String ascendancyClass;
    @DatabaseField(columnName = PTIME_FIELD_NAME)
    public int playTime;
    @DatabaseField(columnName = LEVEL_FIELD_NAME)
    public int level;
    
    public Character(final String setName, final String setClass, final int setPlayTime, final int setLevel) {
        this.name = setName;
        this.classP = setClass;
        this.playTime = setPlayTime;
        this.level = setLevel;
    }
    
    public Character() {
        this.name = "Def";
        this.classP = "None";
        this.playTime = 0;
        this.level = 0;
        this.ascendancyClass = " ";
    }
}
