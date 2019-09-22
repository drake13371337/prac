package DAOApi;

public class Character {
	public String name;
	public String classP;
	public int playTime;
	public int level;
	
	public Character(String setName, String setClass, int setPlayTime, int setLevel){
		this.name=setName;
		this.classP=setClass;
		this.playTime=setPlayTime;
		this.level=setLevel;
	}
	public Character(){
		this.name="Def";
		this.classP="None";
		this.playTime=0;
		this.level=0;
	}
}
