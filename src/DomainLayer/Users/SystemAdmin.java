package DomainLayer.Users;

import DataLayer.UsersDB;
import DomainLayer.Enums;

import java.util.ArrayList;

public class SystemAdmin extends AUser {

    public SystemAdmin(String name, String password, Enums.ActivationStatus status, Enums.UserType userType) {
        super(name, password, status, userType);
    }

    // ------------------------- DB interaction methods -------------------------

    public static boolean VerifySystemAdmin()
    {
        // make sure that we have at least one *active* SystemAdmin (return true if 'yes', false if 'not')
        ArrayList<String> all_users = getAllUsersFromDB();

        for (String user: all_users) {
            String[] user_splitted = user.split(";");
            if(user_splitted[2]==Enums.UserType.SystemAdmin.toString()
                    && user_splitted[3]==Enums.ActivationStatus.ACTIVE.toString())
            {
                return true;
            }
        }
        return false;
    }
}
