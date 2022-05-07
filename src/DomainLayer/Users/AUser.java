package DomainLayer.Users;

import DomainLayer.Enums;

public abstract class AUser {
    private String name;
    private String password;
    private Enums.UserType type;
    private Enums.ActivationStatus activationStatus;

    public AUser(String name, String password, Enums.UserType type, Enums.ActivationStatus activationStatus) {
        this.name = name;
        this.password = password;
        this.type = type;
        this.activationStatus = activationStatus;
    }
    //private int ID; //todo - not needed - delete from task 2
}
