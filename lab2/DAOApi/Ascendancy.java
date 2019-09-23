package DAOApi;

public class Ascendancy{
	public String name;
	public String AscendancyClass;
	
	public Ascendancy(String nameC, String AscendancyClassC){
		this.name=nameC;
		this.AscendancyClass=AscendancyClassC;
	}
	public Ascendancy(){
		this.name="Def";
		this.AscendancyClass="Def";
	}
}
