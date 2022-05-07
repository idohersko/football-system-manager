package DomainLayer.Users;

import DomainLayer.Enums;

public abstract class AUser {
    public static int counter = 0; //todo update from DB in each initialization

    private String name;
    private String password;
    private Enums.UserType type;
    private int ID;
    private Enums.ActivationStatus activationStatus;

    public void LogIn(){
        // todo implement
    }

    public void LogOut(){
        // todo implement
    }
}
