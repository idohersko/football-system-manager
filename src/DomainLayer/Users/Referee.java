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


    public static String FindAvailableReferee()
    {
        // todo implement - Find Available Referee in our DB - return string of it's user name
        //return "" if no such an referee
        return "";
    }

    public Enums.RefereeLevel getRefereeLevel() {
        return refereeLevel;
    }
}
