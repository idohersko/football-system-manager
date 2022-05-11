package DomainLayer.Users;

import DomainLayer.Enums;
import DomainLayer.Games.Team;

public class TeamManager extends AInnerTeamUser {

    public TeamManager(String name, String password, Enums.UserType type, Enums.ActivationStatus activationStatus, Team team) {
        super(name, password, type, activationStatus, team);
    }
}
