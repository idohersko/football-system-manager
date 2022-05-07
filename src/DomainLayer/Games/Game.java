package DomainLayer.Games;

import DomainLayer.Users.Referee;

import java.util.ArrayList;

public class Game {

    public Season season;
    public Team team_1;
    public Team team_2;

    public ArrayList<Referee> referees = new ArrayList<>(5); // todo - size = 5

    public Game(Season season, Team team_1, Team team_2, ArrayList<Referee> referees) {
        this.season = season;
        this.team_1 = team_1;
        this.team_2 = team_2;
        this.referees = referees;
    }
}
