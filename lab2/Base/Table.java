package Base;
import java.util.ArrayList;
import java.util.List;

import DAOApi.Character;
import DAOApi.Ascendancy;
import DAOApi.CharTable;
import DAOApi.AsceTable;


public class Table {
	public static List<Character> list = new ArrayList<Character>();
	public static List<Ascendancy> listA = new ArrayList<Ascendancy>();
	
	public static void main(String[] args) throws Exception{
		CharTable table = new CharTable();
		AsceTable Atable = new AsceTable();
		
		createArr();
		
		table.connect();
		table.create();
		table.insertChar(list);
		
		Atable.connect();
		Atable.create();
		Atable.insertChar(listA);
		
		List<Character> listRes = table.showTable();
		for(Character t : listRes){
			System.out.println(t.name+" "+t.playTime+"h "+t.level+"lvl "+t.classP+" "+t.AscendancyClass);
		}
	}
	
	
	public static void createArr() {
		Character e1 = new Character("Teon", "Duelist", 8, 1);
		Character e2 = new Character("Ferune", "Witch", 89, 23);
		Character e3 = new Character("Fineme", "Witch", 56, 25);
		Character e4 = new Character("Dan", "Scion", 7, 23);
		Character e5 = new Character("Gamart", "Witch", 1, 80);
		Character e6 = new Character("Zarol", "Templar", 24, 74);
		Character e7 = new Character("Anig", "Ranger", 14, 31);
		Character e8 = new Character("Thiale", "Marauder", 20, 58);
		Character e9 = new Character("Ralis", "Witch", 17, 56);
		Character e10 = new Character("Nizan", "Scion", 14, 61);
		Character e11 = new Character("Prinl", "Ranger", 8, 80);
		Character e12 = new Character("Onnedebri", "Ranger", 9, 2);
		Character e13 = new Character("Xunth", "Templar", 18, 10);
		Character e14 = new Character("Veraro", "Shadow", 21, 58);
		Character e15 = new Character("Wagonncrw", "Witch", 45, 61);
		Character e16 = new Character("Zedieytia", "Duelist", 96, 40);
		Character e17 = new Character("Iar", "Templar", 75, 79);
		Character e18 = new Character("TerYrkahai", "Witch", 66, 68);
		Character e19 = new Character("Var", "Duelist", 51, 80);
		Character e20 = new Character("Maloruig", "Shadow", 11, 1);
		
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		list.add(e6);
		list.add(e7);
		list.add(e8);
		list.add(e9);
		list.add(e10);
		list.add(e11);
		list.add(e12);
		list.add(e13);
		list.add(e14);
		list.add(e15);
		list.add(e16);
		list.add(e17);
		list.add(e18);
		list.add(e19);
		list.add(e20);
		
		Ascendancy a1 = new Ascendancy("Teon", "Slayer");
		Ascendancy a2 = new Ascendancy("Ferune", "Occultist");
		Ascendancy a3 = new Ascendancy("Fineme", "Necromancer");
		Ascendancy a4 = new Ascendancy("Dan", "Ascendant");
		Ascendancy a5 = new Ascendancy("Gamart", "Occultist");
		Ascendancy a6 = new Ascendancy("Zarol", "Guardian");
		Ascendancy a7 = new Ascendancy("Anig", "Deadeye");
		Ascendancy a8 = new Ascendancy("Thiale", "Juggernaut");
		Ascendancy a9 = new Ascendancy("Ralis", "Elementalist");
		Ascendancy a10 = new Ascendancy("Nizan", "Ascendant");
		Ascendancy a11 = new Ascendancy("Prinl", "Pathfinder");
		Ascendancy a12 = new Ascendancy("Onnedebri", "Pathfinder");
		Ascendancy a13 = new Ascendancy("Xunth", "Guardian");
		Ascendancy a14 = new Ascendancy("Veraro", "Saboteur");
		Ascendancy a15 = new Ascendancy("Wagonncrw", "Occultist");
		Ascendancy a16 = new Ascendancy("Zedieytia", "Champion");
		Ascendancy a17 = new Ascendancy("Iar", "Inquisitor");
		Ascendancy a18 = new Ascendancy("TerYrkahai", "Elementalist");
		Ascendancy a19 = new Ascendancy("Var", "Slayer");
		Ascendancy a20 = new Ascendancy("Maloruig", "Saboteur");
		
		listA.add(a1);
		listA.add(a2);
		listA.add(a3);
		listA.add(a4);
		listA.add(a5);
		listA.add(a6);
		listA.add(a7);
		listA.add(a8);
		listA.add(a9);
		listA.add(a10);
		listA.add(a11);
		listA.add(a12);
		listA.add(a13);
		listA.add(a14);
		listA.add(a15);
		listA.add(a16);
		listA.add(a17);
		listA.add(a18);
		listA.add(a19);
		listA.add(a20);
	}
}
