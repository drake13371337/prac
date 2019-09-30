package DAOApi;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Ascendancy")
public class Ascendancy
{
	public static final String CLASS_FIELD_NAME = "ascendancyClass";
	public static final String NAME_FIELD_NAME = "name";
	
	@DatabaseField(generatedId = true)
	public int aId;
	@DatabaseField(columnName = NAME_FIELD_NAME)
    public String name;
	@DatabaseField(columnName = CLASS_FIELD_NAME)
    public String ascendancyClass;
    
    public Ascendancy(final String nameC, final String AscendancyClassC) {
        this.name = nameC;
        this.ascendancyClass = AscendancyClassC;
    }
    
    public Ascendancy() {}
}