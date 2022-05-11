package DomainLayer.Games;

import DomainLayer.Users.Referee;

import java.util.ArrayList;

public class Season {
    public ArrayList<Referee> referees = new ArrayList<>();
    public ArrayList<Game> games = new ArrayList<>();
    public League league;


    public Season(League league) {
        this.league = league;
    }
}
