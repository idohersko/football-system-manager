package DomainLayer.Users;

import DomainLayer.Enums;

public class Fan extends AUser {


    public Fan(String name, String password, Enums.UserType type, Enums.ActivationStatus activationStatus) {
        super(name, password, type, activationStatus);
    }
}
