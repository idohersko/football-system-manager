package DomainLayer.Users;
import DataLayer.LeaguesDB;
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

//    public static ArrayList<String> getAllRefereeFromDB()
//    {
//        RefereeDB refereeDB = RefereeDB.getInstance();
//        return refereeDB.getAll();
//    }
//
//    public static String FindAvailableReferee()
//    {
//        ArrayList<String> all_leagues = getAllRefereeFromDB();
//
//
//        for (String league: all_leagues) {
//            String[] league_split = league.split(";");
//            if(league_split[0]==LeagueName)
//            {
//                return true;
//            }
//        }
//        return "";
//    }

    public Enums.RefereeLevel getRefereeLevel() {
        return refereeLevel;
    }
}
