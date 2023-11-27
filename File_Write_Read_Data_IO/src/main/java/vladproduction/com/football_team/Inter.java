package vladproduction.com.football_team;

public class Inter {

    public String name;

    public int number;


    @Override
    public String toString() {
        return "Inter <" +
                "player:" + name + '\'' +
                ", # " + number +
                '>';
    }
}
