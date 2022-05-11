package DomainLayer.Users;
import DomainLayer.Enums;

import java.util.ArrayList;

public class Referee extends AUser {
    public Enums.RefereeLevel refereeLevel;

    public ArrayList<String> seasons = new ArrayList<>();
    public ArrayList<Enums.EventType> events = new ArrayList<>();

    public Referee(String name, String password, Enums.ActivationStatus status, Enums.UserType userType, Enums.RefereeLevel refereeLevel) {
        super(name, password, status, userType);
        this.refereeLevel = refereeLevel;

    }
}
