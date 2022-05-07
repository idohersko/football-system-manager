package DomainLayer.Games;

import DomainLayer.Users.TeamOwner;

import java.util.ArrayList;

public class Team {
    public TeamOwner teamOwner;
    public League league;
    public ArrayList<Game> games = new ArrayList<>();

    public Team(TeamOwner teamOwner, League league) {
        this.teamOwner = teamOwner;
        this.league = league;
    }
}
