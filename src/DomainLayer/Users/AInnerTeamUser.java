package DomainLayer.Users;

//todo : in CD - change team user to abstract class

import DomainLayer.Enums;
import DomainLayer.Games.Team;

public abstract class AInnerTeamUser extends AUser {
    public Team team;

    public AInnerTeamUser(String name, String password, Enums.UserType type, Enums.ActivationStatus activationStatus, Team team) {
        super(name, password, type, activationStatus);
        this.team = team;
    }
}
