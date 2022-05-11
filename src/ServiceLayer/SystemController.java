package ServiceLayer;

import DomainLayer.Enums;
import DomainLayer.Users.AUser;

import java.util.ArrayList;

public class SystemController {
    private static SystemController systemControllerInstance;

    private SystemController() {
    }

    public static SystemController getInstance() {
        if (systemControllerInstance == null){
            systemControllerInstance = new SystemController();
        }
        return systemControllerInstance;
    }


    public Enums.ActionStatus LogInUser(String userName, String password){
        if(userName == null || password == null)
        {
            return Enums.ActionStatus.WRONG_PARAMETERS;
        }
        return AUser.LogInUserToDB(userName, password);
    }

    public Enums.ActionStatus SetNewGame(String AssociationRepresentativeUserName, String LeagueName)
    {
        //todo implement & update DB
        // make sure that AssociationRepresentativeUserName is looged in (add test of logged out case)

        return Enums.ActionStatus.SUCCESS;
    }

    public Enums.ActionStatus SignNewReferee()
    {
        //todo implement & update DB
        return Enums.ActionStatus.SUCCESS;
    }

    public boolean VerifySystemAdmin()
    {
        //todo implement - make sure we have at least one (true if yes, false if not)
        // todo: test there is at least one signed-in system admin (undergone a registration process).
        //  this admin must be a user  (passed the registration process).

        return false;
    }

    private static Enums.UserType StringToUserType(int userType) {
        return switch (userType) {
            case 1 -> Enums.UserType.Coach;
            case 2 -> Enums.UserType.Fan;
            case 3 -> Enums.UserType.Player;
            case 4 -> Enums.UserType.Referee;
            case 5 -> Enums.UserType.SystemAdmin;
            case 6 -> Enums.UserType.TeamManager;
            case 7 -> Enums.UserType.TeamOwner;
            default -> null;
        };
    }

}
