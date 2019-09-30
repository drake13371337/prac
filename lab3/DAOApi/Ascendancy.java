package DAOApi;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Ascendancy")
public class Ascendancy
{
	public static final String CLASS_FIELD_NAME = "ascendancyClass";
	
	@DatabaseField(foreign = true, generatedId = true)
    public String name;
	@DatabaseField(columnName = CLASS_FIELD_NAME)
    public String ascendancyClass;
    
    public Ascendancy(final String nameC, final String AscendancyClassC) {
        this.name = nameC;
        this.ascendancyClass = AscendancyClassC;
    }
    
    public Ascendancy() {
        this.name = "Def";
        this.ascendancyClass = "Def";
    }
}