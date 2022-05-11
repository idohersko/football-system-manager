package DomainLayer.Games;

import DomainLayer.Enums;
import DomainLayer.Users.Referee;

import java.util.ArrayList;


public class Game {
    public String date;
    public String time;
    public Season season;
    public String field;
    public Team team_home;
    public Team team_guest;
    public ArrayList<Referee> referees = new ArrayList<>();
    public int score;
    public ArrayList<Enums.EventType> events = new ArrayList<>();


    public Game(String date, String time, Season season, String field, Team team_home, Team team_guest, ArrayList<Referee> referees) {
        this.date = date;
        this.time = time;
        this.season = season;
        this.field = field;
        this.team_home = team_home;
        this.team_guest = team_guest;
        this.referees = referees;
    }
}
