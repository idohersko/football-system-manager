package DomainLayer.Games;

import DataLayer.GamesDB;
import DataLayer.UsersDB;
import DomainLayer.Enums;
import DomainLayer.Users.Referee;

import java.util.ArrayList;


public class Game {
    public String date;
    public String season;
    public String team_home;
    public String team_guest;
    public String field;
    public ArrayList<String> referees = new ArrayList<>();
    public int score;
    public ArrayList<Enums.EventType> events = new ArrayList<>();

    public Game(String date, String season, String field, String team_home, String team_guest, ArrayList<String> referees) {
        this.date = date;
        this.season = season;
        this.field = field;
        this.team_home = team_home;
        this.team_guest = team_guest;
        this.referees = referees;
    }

    // ------------------------- DB interaction methods -------------------------

    public static Enums.ActionStatus AddNewGameToDB(String date, String season, String field, String team_home, String team_guest, ArrayList<String> referees)
    {
        // add the end of this func - we have new game in games DB
        Game game = new Game(date, season, field, team_home, team_guest, referees);

        GamesDB gamesDB = GamesDB.getInstance();
        try {
            gamesDB.save(game);
        }
        catch (Exception e)
        {
            return Enums.ActionStatus.FAIL;
        }

        return Enums.ActionStatus.SUCCESS;
    }

    public static ArrayList<String> getAllGamesFromDB()
    {
        GamesDB gamesDB = GamesDB.getInstance();
        return gamesDB.getAll();
    }

    public String getDate() {
        return date;
    }

    public String getSeason() {
        return season;
    }

    public String getTeam_home() {
        return team_home;
    }

    public String getTeam_guest() {
        return team_guest;
    }

    public String getField() {
        return field;
    }

    public ArrayList<String> getReferees() {
        return referees;
    }
}
