package DomainLayer.Users;

import DataLayer.UsersDB;
import DomainLayer.Enums;

import java.util.ArrayList;

public abstract class AUser {
    private String name;
    private String password;
    private Enums.ActivationStatus status;
    private Enums.UserType userType;

    public AUser(String name, String password, Enums.ActivationStatus status, Enums.UserType userType) {
        this.name = name;
        this.password = password;
        this.status = status;
        this.userType = userType;
    }

    //private int ID; //todo - not needed - delete from task 2

    // ------------------------- DB interaction methods -------------------------

    public static Enums.ActionStatus LogInUserToDB(String userName, String password)
    {
        SystemAdmin temp_user = new SystemAdmin(userName, password, Enums.ActivationStatus.INACTIVE,Enums.UserType.SystemAdmin);
        UsersDB usersDB = UsersDB.getInstance();
        try {
            usersDB.update(temp_user,new String[]{Enums.ActivationStatus.ACTIVE.toString()});
        }
        catch (Exception e)
        {
            return Enums.ActionStatus.FAIL;
        }

        // todo implement what happens if password is wrong / user doesn't exist, and if it's already logged in

        // login user in DB records
        //todo add check if this userName exist - only signed user can log in!
        // if no - return error, if yes - log in & update DB with new status = ACTIVE

        return Enums.ActionStatus.SUCCESS;
    }

    // ------------------------- Getters & Setters -------------------------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Enums.ActivationStatus getStatus() {
        return status;
    }

    public void setStatus(Enums.ActivationStatus status) {
        this.status = status;
    }

    public Enums.UserType getUserType() {
        return userType;
    }

    public void setUserType(Enums.UserType userType) {
        this.userType = userType;
    }
}
