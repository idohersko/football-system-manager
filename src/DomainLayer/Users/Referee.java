package DomainLayer.Users;
import DomainLayer.Enums;
import DomainLayer.Games.Season;
import java.util.ArrayList;

public class Referee extends AUser {
    public ArrayList<Season> seasons = new ArrayList<>();
    public ArrayList<Enums.EventType> events = new ArrayList<>();

}
