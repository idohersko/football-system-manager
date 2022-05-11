package DomainLayer.Users;

import DomainLayer.Enums;
import DomainLayer.Games.League;
import DomainLayer.Games.Season;

public class SystemAdmin extends AUser {

    public SystemAdmin(String name, String password) {
        super(name, password);
    }

    // ------------------------- DB interaction methods -------------------------

    public static Enums.ActionStatus VerifySystemAdmin()
    {
        // todo - implemnt check with users DB
        return Enums.ActionStatus.SUCCESS;
    }
}
