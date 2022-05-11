package DomainLayer.Users;

import DomainLayer.Enums;
import DomainLayer.Games.League;
import DomainLayer.Games.Season;

public class SystemAdmin extends AUser {

    public SystemAdmin(String name, String password) {
        super(name, password);
    }

    // ------------------------- DB interaction methods -------------------------

    public static boolean VerifySystemAdmin()
    {
        // todo - implemnt check with users DB:
        //todo implement - make sure we have at least one (true if yes, false if not)
        // todo: test there is at least one signed-in system admin (undergone a registration process).
        //  this admin must be a user  (passed the registration process).
        return false;
    }
}
