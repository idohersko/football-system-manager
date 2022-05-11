package DomainLayer.Games;

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
}
