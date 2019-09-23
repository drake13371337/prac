package DAOApi;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CharTable extends CharDB{
	public static ResultSet rs;
	public CharTable() {}
	
	public void insertChar(List<Character> listP) throws Exception{
		for(Character t : listP){
			st.execute("INSERT INTO Character VALUES('"+t.name+"', '"+t.classP+"', "+t.playTime+", "+t.level+");");
		}
	}
	public List<Character> showTable() throws Exception{
		List<Character> buff = new ArrayList<Character>();
		rs = st.executeQuery("SELECT * from Character");
		while(rs.next()){
			Character charBuff = new Character();
			charBuff.name=rs.getString("name");
			charBuff.classP=rs.getString("class");
			charBuff.playTime=Integer.parseInt(rs.getString("playTime"));
			charBuff.level=Integer.parseInt(rs.getString("level"));
			buff.add(charBuff);
		}
		return(buff);
	}
	public List<Character> showClass(String classC) throws Exception {
		List<Character> buff = new ArrayList<Character>();
		rs = st.executeQuery("SELECT * from Character WHERE class='"+classC+"'");
		while(rs.next()){
			Character charBuff = new Character();
			charBuff.name=rs.getString("name");
			charBuff.classP=rs.getString("class");
			charBuff.playTime=Integer.parseInt(rs.getString("playTime"));
			charBuff.level=Integer.parseInt(rs.getString("level"));
			buff.add(charBuff);
		}
		return buff;
	}
	public List<Character> showTableAscendancy() throws Exception {
		List<Character> buff = new ArrayList<Character>();
		rs = st.executeQuery("SELECT * from Character INNER JOIN Ascendancy ON Character.name=Ascendancy.namea");
		while(rs.next()){
			Character charBuff = new Character();
			charBuff.name=rs.getString("name");
			charBuff.classP=rs.getString("class");
			charBuff.playTime=Integer.parseInt(rs.getString("playTime"));
			charBuff.level=Integer.parseInt(rs.getString("level"));
			charBuff.AscendancyClass=rs.getString("ascendancyClass");
			buff.add(charBuff);
		}
		return buff;
	}
}
