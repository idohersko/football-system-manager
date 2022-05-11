package DomainLayer.Users;

import DomainLayer.Enums;
import DomainLayer.Games.League;
import DomainLayer.Games.Season;

public class SystemAdmin extends AUser {

    public SystemAdmin(String name, String password, Enums.UserType type, Enums.ActivationStatus activationStatus) {
        super(name, password, type, activationStatus);
    }
}
