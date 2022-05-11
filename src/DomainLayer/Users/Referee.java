package DomainLayer.Users;
import DataLayer.LeaguesDB;
import DataLayer.RefereesDB;
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

    public static ArrayList<String> getAllRefereeFromDB()
    {
        RefereesDB refereeDB = RefereesDB.getInstance();
        return refereeDB.getAll();
    }

    public static String FindAvailableReferee()
    {
        ArrayList<String> all_referees = getAllRefereeFromDB();

        for (String referee: all_referees) {
            String[] referee_split = referee.split(";");
            return referee_split[0];
        }
        return "";
    }

    public Enums.RefereeLevel getRefereeLevel() {
        return refereeLevel;
    }
}
