package DomainLayer.Users;

import DomainLayer.Games.Team;

// todo - support: A team owner can also be a player, coach and manager

public class TeamOwner extends AInnerTeamUser {

    public TeamOwner(Team team) {
        super(team);
    }

    public void SignNewTeam(){
        // not implemented
    }

    public void AddPlayer(){
        // not implemented
    }

    public void AddCoach(){
        // todo implement
    }

    public void AddTeamManager(){
        // not implemented
    }
}
