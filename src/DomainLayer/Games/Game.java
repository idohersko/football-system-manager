package DomainLayer.Games;

import DomainLayer.Enums;
import DomainLayer.Users.Referee;

import java.util.ArrayList;


public class Game {
    public String date;
    public Season season;
    public Team team_home;
    public Team team_guest;
    public String field;
    public ArrayList<Referee> referees = new ArrayList<>();
    public int score;
    public ArrayList<Enums.EventType> events = new ArrayList<>();


    public Game(String date, Season season, String field, Team team_home, Team team_guest, ArrayList<Referee> referees) {
        this.date = date;
        this.season = season;
        this.field = field;
        this.team_home = team_home;
        this.team_guest = team_guest;
        this.referees = referees;
    }
}
