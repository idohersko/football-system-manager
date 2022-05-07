package DomainLayer.Users;

import DomainLayer.Enums;
import DomainLayer.Games.Team;

public class Player extends AInnerTeamUser {
    public String birthday;
    public String position;

    public Player(String name, String password, Enums.UserType type, Enums.ActivationStatus activationStatus, Team team, String birthday, String position) {
        super(name, password, type, activationStatus, team);
        this.birthday = birthday;
        this.position = position;
    }

}
