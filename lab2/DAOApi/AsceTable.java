package DAOApi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AsceTable extends AsceDB{
	public static ResultSet rs;
	public AsceTable() {}
	
	public void insertChar(List<Ascendancy> listP) throws Exception{
		for(Ascendancy t : listP){
			st.execute("INSERT INTO Ascendancy VALUES('"+t.name+"', '"+t.AscendancyClass+"');");
		}
	}
}
