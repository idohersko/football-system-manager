package DomainLayer.Users;
import DomainLayer.Enums;
import DomainLayer.Games.Season;
import java.util.ArrayList;

public class Referee extends AUser {
    public String training;

    public ArrayList<Season> seasons = new ArrayList<>();
    public ArrayList<Enums.EventType> events = new ArrayList<>();


    public Referee(String name, String password, Enums.UserType type, Enums.ActivationStatus activationStatus, String training) {
        super(name, password, type, activationStatus);
        this.training = training;
    }
}
