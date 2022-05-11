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

    // ------------------------- DB interaction methods -------------------------

    public static Enums.ActionStatus LogInUserToDB(String userName, String password)
    {
        // login user in DB records

        //todo add check if this userName exist - only signed user can log in!
        // if no - return error, if yes - log in & update DB with new status = ACTIVE

        return Enums.ActionStatus.SUCCESS;
    }

    public static Enums.ActionStatus LogOutUserToDB(String userName)
    {
        // logout user in DB records

        //todo add check if this userName exist and active - only active logged in user can log out!
        // if no - return error, if yes - log out & update DB with new status

        return Enums.ActionStatus.SUCCESS;
    }

}
