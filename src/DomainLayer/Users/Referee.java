package DomainLayer.Users;
import DomainLayer.Enums;

import java.util.ArrayList;

public class Referee extends AUser {

    public Enums.RefereeLevel refereeLevel;

    public ArrayList<Season> seasons = new ArrayList<>();
    public ArrayList<Enums.EventType> events = new ArrayList<>();

    public Referee(String name, String password, Enums.RefereeLevel refereeLevel) {
        super(name, password);
        this.refereeLevel = refereeLevel;
    }
}
