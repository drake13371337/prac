package DAOApi;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Character")
public class Character{
    public String name;
    public String classP;
    public String ascendancyClass;
    public int playTime;
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
