package ServiceLayer;

// singletone

public class SystemController {
    private static SystemController systemControllerInstance; // singletone

    private SystemController() {
        //todo implement
    }

    public static SystemController getInstance() {
        if (systemControllerInstance == null){
            systemControllerInstance = new SystemController();
        }
        return systemControllerInstance;
    }

    public static void LogIn()
    {
        //todo implement
    }

    public static void LogOut()
    {
        //todo implement
    }

    public static void AddNewGame()
    {
        //todo implement
    }

    public static void SignNewReferee()
    {
        //todo implement
    }

}
