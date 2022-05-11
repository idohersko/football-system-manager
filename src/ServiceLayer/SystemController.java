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


    public Enums.ActionStatus LogInUser(String userName, String password) throws Exception {
        if(userName == null || password == null)
        {
            throw new Exception("Null input parameters");
        }
        // todo implement what happens if password is wrong / user doesn't exist
        return AUser.LogInUserToDB(userName, password);
    }

    public Enums.ActionStatus LogOutUser(String userName) throws Exception {
        if(userName == null)
        {
            throw new Exception("Null input parameter");
        }
        // todo implement what happens if  user doesn't exist
        // todo - implemet what happens if user is already logged out
        return AUser.LogOutUserToDB(userName);
    }

    public Enums.ActionStatus SetNewGame()
    {
        //todo implement & update DB
        return Enums.ActionStatus.SUCCESS;
    }

    public Enums.ActionStatus SignNewReferee()
    {
        //todo implement & update DB
        return Enums.ActionStatus.SUCCESS;
    }

    public ArrayList GetAllSystemUsernames()
    {
        //todo implement- return all user names from DB
        return new ArrayList();
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
