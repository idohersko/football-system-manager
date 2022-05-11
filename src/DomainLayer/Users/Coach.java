package DomainLayer.Users;

import DomainLayer.Enums;
import DomainLayer.Games.Team;

public class Coach extends AInnerTeamUser{
    public String training;
    public String position;

    public Coach(String name, String password, Enums.UserType type, Enums.ActivationStatus activationStatus, Team team, String training, String position) {
        super(name, password, type, activationStatus, team);
        this.training = training;
        this.position = position;
    }
}
