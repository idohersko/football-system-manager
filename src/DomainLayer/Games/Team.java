package DomainLayer.Games;

import java.util.ArrayList;

public class Team {
    public String teamOwner;
    public League league;
    public ArrayList<Game> games = new ArrayList<>();

    public Team(String teamOwner, League league) {
        this.teamOwner = teamOwner;
        this.league = league;
    }
}
