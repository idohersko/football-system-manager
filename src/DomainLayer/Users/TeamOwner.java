package DomainLayer.Users;

import DomainLayer.Enums;
import DomainLayer.Games.Team;

// todo - support: A team owner can also be a player, coach and manager

public class TeamOwner extends AInnerTeamUser {

    public TeamOwner(String name, String password, Enums.UserType type, Enums.ActivationStatus activationStatus, Team team) {
        super(name, password, type, activationStatus, team);
    }
}
