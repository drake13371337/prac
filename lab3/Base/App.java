package Application;

import java.util.*;
import DAOApi.*;
import DAOApi.Ascendancy;
import DAOApi.Character;

public class App
{
    public static void main(final String[] args) throws Exception {
        final CharDB DataBase = new CharDB();
        DataBase.connect();
        DataBase.create();
        
        DataBase.table.insertChar(create1());
        DataBase.tableA.insertChar(create2());
        
        final List<Character> listRes = DataBase.table.getTable();
        for (final Character t : listRes) {
            System.out.println(String.valueOf(t.name) + " " + t.playTime + "h " + t.level + "lvl " + t.classP + " " + t.ascendancyClass);
        }
    }
    
    public static List<Character> create1() {
        final List<Character> list = new ArrayList<Character>();
        list.add(new Character("Teon", "Duelist", 8, 1));
        list.add(new Character("Ferune", "Witch", 89, 23));
        list.add(new Character("Fineme", "Witch", 56, 25));
        list.add(new Character("Dan", "Scion", 7, 23));
        list.add(new Character("Gamart", "Witch", 1, 80));
        list.add(new Character("Zarol", "Templar", 24, 74));
        list.add(new Character("Anig", "Ranger", 14, 31));
        list.add(new Character("Thiale", "Marauder", 20, 58));
        list.add(new Character("Ralis", "Witch", 17, 56));
        list.add(new Character("Nizan", "Scion", 14, 61));
        list.add(new Character("Prinl", "Ranger", 8, 80));
        list.add(new Character("Onnedebri", "Ranger", 9, 2));
        list.add(new Character("Xunth", "Templar", 18, 10));
        list.add(new Character("Veraro", "Shadow", 21, 58));
        list.add(new Character("Wagonncrw", "Witch", 45, 61));
        list.add(new Character("Zedieytia", "Duelist", 96, 40));
        list.add(new Character("Iar", "Templar", 75, 79));
        list.add(new Character("TerYrkahai", "Witch", 66, 68));
        list.add(new Character("Var", "Duelist", 51, 80));
        list.add(new Character("Maloruig", "Shadow", 11, 1));
        return list;
    }
    
    public static List<Ascendancy> create2() {
        final List<Ascendancy> list = new ArrayList<Ascendancy>();
        list.add(new Ascendancy("Teon", "Slayer"));
        list.add(new Ascendancy("Ferune", "Occultist"));
        list.add(new Ascendancy("Fineme", "Necromancer"));
        list.add(new Ascendancy("Dan", "Ascendant"));
        list.add(new Ascendancy("Gamart", "Occultist"));
        list.add(new Ascendancy("Zarol", "Guardian"));
        list.add(new Ascendancy("Anig", "Deadeye"));
        list.add(new Ascendancy("Thiale", "Juggernaut"));
        list.add(new Ascendancy("Ralis", "Elementalist"));
        list.add(new Ascendancy("Nizan", "Ascendant"));
        list.add(new Ascendancy("Prinl", "Pathfinder"));
        list.add(new Ascendancy("Onnedebri", "Pathfinder"));
        list.add(new Ascendancy("Xunth", "Guardian"));
        list.add(new Ascendancy("Veraro", "Saboteur"));
        list.add(new Ascendancy("Wagonncrw", "Occultist"));
        list.add(new Ascendancy("Zedieytia", "Champion"));
        list.add(new Ascendancy("Iar", "Inquisitor"));
        list.add(new Ascendancy("TerYrkahai", "Elementalist"));
        list.add(new Ascendancy("Var", "Slayer"));
        list.add(new Ascendancy("Maloruig", "Saboteur"));
        return list;
    }
}