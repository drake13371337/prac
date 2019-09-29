package DAOApi;

public class Ascendancy
{
    public String name;
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