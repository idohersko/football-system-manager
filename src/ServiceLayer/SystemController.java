package ServiceLayer;

// singletone

import DomainLayer.Games.Game;
import DomainLayer.Users.AUser;
import DomainLayer.Users.Guest;

import java.util.ArrayList;

public class SystemController {
    private static SystemController systemControllerInstance; // singletone

    private ArrayList<Guest> guests = new ArrayList<>();
    private ArrayList<AUser> users = new ArrayList<>();
    private ArrayList<Game> games = new ArrayList<>();

    private SystemController() {
        // todo add read from DB and fill arrays
    }

    public static SystemController getInstance() {
        if (systemControllerInstance == null){
            systemControllerInstance = new SystemController();
        }
        return systemControllerInstance;
    }

    public static void LogIn(String userName, String password, String userType)
    {
        //todo implement & update DB
    }

    public static void LogOut(String userName)
    {
        //todo implement & update DB
    }

    public static void AddNewGame()
    {
        //todo implement & update DB
    }

    public static void SignNewReferee()
    {
        //todo implement & update DB
    }

    //todo dar was need
    public ArrayList<Guest> getGuests() {
        return guests;
    }

    public ArrayList<AUser> getUsers() {
        return users;
    }

    public ArrayList<Game> getGames() {
        return games;
    }
}
