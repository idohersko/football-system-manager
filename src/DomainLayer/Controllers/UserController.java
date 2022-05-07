package DomainLayer.Controllers;

import DomainLayer.Enums;
import ServiceLayer.SystemController;

public class UserController {
    private static UserController userControllerInstance; // singletone

    private UserController() {
    }

    public static UserController getInstance() {
        if (userControllerInstance == null){
            userControllerInstance = new UserController();
        }
        return userControllerInstance;
    }

    public Enums.ActionStatus SignInNewUser(String userName, String password, Enums.UserType userType)
    {
        //todo add check if this userName already exist - only one user per user name!
        // if yes - return error , if no - sign in & update DB with new user

        return Enums.ActionStatus.SUCCESS;
    }

    public Enums.ActionStatus LogInUser(String userName, String password, Enums.UserType userType)
    {
        //todo add check if this userName exist - only signed user can log in!
        // if no - return error, if yes - log in & update DB with new status

        return Enums.ActionStatus.SUCCESS;
    }

    public Enums.ActionStatus LogOutUser(String userName)
    {
        //todo add check if this userName exist and active - only active logged in user can log out!
        // if no - return error, if yes - log out & update DB with new status

        return Enums.ActionStatus.SUCCESS;
    }
}
