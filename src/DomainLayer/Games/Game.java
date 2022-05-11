package DomainLayer.Games;

import DomainLayer.Users.Referee;

import java.util.ArrayList;

public class Game {
    public String date;
    public String time;
    public Season season;
    public Team team_home;
    public Team team_guest;

    public ArrayList<Referee> referees = new ArrayList<>(5); // todo - size = 5

    public Game(String date, String time, Season season, Team team_home, Team team_guest) {
        this.date = date;
        this.time = time;
        this.season = season;
        this.team_home = team_home;
        this.team_guest = team_guest;
    }
}
