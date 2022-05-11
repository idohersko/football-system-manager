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

}
