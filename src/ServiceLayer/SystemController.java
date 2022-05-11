package ServiceLayer;

import DomainLayer.Enums;
import DomainLayer.Users.AUser;

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


    public Enums.ActionStatus LogIn(String userName, String password, Enums.UserType userType)
    {
        return AUser.LogInUserToDB(userName, password, userType);
    }

    public Enums.ActionStatus LogOut(String userName)
    {

        return AUser.LogOutUserToDB(userName);
    }

    public Enums.ActionStatus AddNewGame()
    {
        //todo implement & update DB - different controller
        return Enums.ActionStatus.SUCCESS;

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
