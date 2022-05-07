package DomainLayer.Users;

//todo : in CD - change team user to abstract class

import DomainLayer.Games.Team;

public abstract class AInnerTeamUser extends AUser {
    public Team team;

    public AInnerTeamUser(Team team) {
        this.team = team;
    }
}
