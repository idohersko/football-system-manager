package DomainLayer.Users;
import DomainLayer.Enums;
import DomainLayer.Games.Season;
import java.util.ArrayList;

public class Referee extends AUser {
    public String training;
    public Enums.RefereeLevel refereeLevel;

    public ArrayList<Season> seasons = new ArrayList<>();
    public ArrayList<Enums.EventType> events = new ArrayList<>();

    public Referee(String name, String password) {
        super(name, password);
    }
}
