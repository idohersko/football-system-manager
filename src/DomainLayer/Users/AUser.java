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

    // ------------------------- DB interaction methods -------------------------

    public static ArrayList<String> getAllUsersFromDB()
    {
        UsersDB usersDB = UsersDB.getInstance();
        return usersDB.getAll();
    }

    public static Enums.ActionStatus LogInUserToDB(String userName, String password)
    {
        ArrayList<String> all_users = getAllUsersFromDB();

        // check if user exists, if yes 0 verify it's password
        for (String user: all_users) {
            String[] user_splitted = user.split(";");
            if(user_splitted[0]==userName)
            {
                if(user_splitted[1]!=password)
                {
                    return Enums.ActionStatus.FAIL;
                }
                // write to DB - change user to active state
                UsersDB usersDB = UsersDB.getInstance();
                try {
                    usersDB.update(new SystemAdmin(userName, password, Enums.ActivationStatus.INACTIVE,Enums.UserType.SystemAdmin ),new String[]{});
                }
                catch (Exception e)
                {
                    return Enums.ActionStatus.FAIL;
                }
                return Enums.ActionStatus.SUCCESS;
            }
        }
        return Enums.ActionStatus.FAIL;
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
