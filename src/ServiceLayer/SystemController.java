package ServiceLayer;

import DomainLayer.Enums;
import DomainLayer.Controllers.UserController;

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
        return UserController.getInstance().LogInUser(userName, password, userType);
    }

    public Enums.ActionStatus LogOut(String userName)
    {
        return UserController.getInstance().LogOutUser(userName);
    }

    public Enums.ActionStatus AddNewGame()
    {
        //todo implement & update DB - different controller
        return Enums.ActionStatus.SUCCESS;

    }

}
