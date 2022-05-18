package DomainLayer.Games;
import DataLayer.LeaguesDB;
import DataLayer.TeamsDB;
import DomainLayer.Users.AssociationRepresentative;

import java.util.ArrayList;

public class League {
    public String LeagueName;
    public ArrayList<String> seasons = new ArrayList<>();
    public ArrayList<Team> teams = new ArrayList<>();
    public ArrayList<AssociationRepresentative> associationRepresentatives = new ArrayList<>();

    public League(AssociationRepresentative associationRepresentative, String LeagueName) {
        this.associationRepresentatives.add(associationRepresentative);
        this.LeagueName = LeagueName;
    }

    public static ArrayList<String> getAllLeaguesFromDB()
    {
        LeaguesDB leaguesDB = LeaguesDB.getInstance();
        return leaguesDB.getAll();
    }

    public static boolean CheckLeagueExists(String LeagueName)
    {
        // check that the League exists
        ArrayList<String> all_leagues = getAllLeaguesFromDB();

        for (String league: all_leagues) {
            String[] league_split = league.split(";");
            if(league_split[0].equals(LeagueName))
            {
                    return true;
            }
        }
        return false;
    }
}
