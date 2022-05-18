package DomainLayer.Games;

import DataLayer.TeamsDB;
import DataLayer.UsersDB;
import DomainLayer.Enums;
import DomainLayer.Users.SystemAdmin;

import java.util.ArrayList;

public class Team {
    public String teamName;
    public String teamOwner;
    public League league;
    public ArrayList<Game> games = new ArrayList<>();

    public Team(String teamName, String teamOwner, League league) {
        this.teamName = teamName;
        this.teamOwner = teamOwner;
        this.league = league;
    }

    public static ArrayList<String> getAllTeamFromDB()
    {
        TeamsDB teamsDB = TeamsDB.getInstance();
        return teamsDB.getAll();
    }

    public static boolean CheckTeamExistsWithTheLeague(String teamName, String leagueName)
    {
        // check that the team exists and have this league
        ArrayList<String> all_teams = getAllTeamFromDB();

        for (String team: all_teams) {
            String[] team_split = team.split(";");
            if(team_split[0].equals(teamName))
            {
                if(team_split[1].equals(leagueName))
                {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getTeamOwner() {
        return teamOwner;
    }

    public League getLeague() {
        return league;
    }

    public ArrayList<Game> getGames() {
        return games;
    }
}
