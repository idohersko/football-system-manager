package DomainLayer.Users;

import DomainLayer.Enums;
import DomainLayer.Games.Team;

public abstract class AInnerTeamUser extends AUser {
    public Team team;


    public AInnerTeamUser(String name, String password, Enums.ActivationStatus status, Enums.UserType userType, Team team) {
        super(name, password, status, userType);
        this.team = team;
    }
}
