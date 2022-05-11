package DomainLayer.Games;

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


    public Game(String date, String season, String field, String team_home, String team_guest, String referee) {
        this.date = date;
        this.season = season;
        this.field = field;
        this.team_home = team_home;
        this.team_guest = team_guest;
        this.referees.add(referee);
    }

    // ------------------------- DB interaction methods -------------------------

    public static Enums.ActionStatus AddNewGameToDB(String date, String season, String field, String team_home, String team_guest, String referee)
    {
        // todo - add the end of this func
        //  we have new game in games DB, the teams connected to this game in their DB, referee also,


        return Enums.ActionStatus.SUCCESS;
    }
}
