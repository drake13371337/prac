package Base;
import java.util.ArrayList;
import java.util.List;

import DAOApi.Character;
import DAOApi.CharTable;


public class Table {
	public static List<Character> list = new ArrayList<Character>();
	
	public static void main(String[] args) throws Exception{
		CharTable table = new CharTable();
		createArr();
		table.connect();
		//table.create();
		//table.insertChar(list);
		List<Character> listRes = table.showClass("Witch");
		for(Character t : listRes){
			System.out.println(t.name+" "+t.playTime+"h "+t.level+"lvl "+t.classP);
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
	}
}
