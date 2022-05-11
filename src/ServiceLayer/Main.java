package ServiceLayer;
import DomainLayer.Enums;
import java.util.Scanner;

/*
* //
* todo ask maxim on the main loop  , and if it's ok to start with some objects in the system,
* and if we need to implement only the 3 UC or all functions?
like - reports, complaints, log, sign in for all users, remove users, see their details?..
*
*
* todo do we need to handle Sign In UC, or only log in?
// todo We didn't handle sign in UC, only log in and sign in for FAN type (guests only)
* */

// todo - start with some employs, teams (and what needed for the 3 UC) in the system DB - can't sign in from this main
// todo - compare to task 2 - write all differences at the end

//todo : At this point make sure there is at least one signed-in system admin (undergone a registration process).
// this admin must be a user  (passed the registration process).


public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
    }

    private static Enums.ActionStatus LogIn(Enums.UserType userType) {
        System.out.println("Please enter User-Name: ");
        String userName = sc.nextLine();
        System.out.println("Please enter User-Password: ");
        String userPassword = sc.nextLine();
        return SystemController.getInstance().LogIn(userName, userPassword, userType);
    }

    private static Enums.ActionStatus logOut() {
        System.out.println("Please enter User-Name: ");
        String userName = sc.nextLine();
        return SystemController.getInstance().LogOut(userName);
    }

    private static Enums.ActionStatus AddNewGame() {
        //todo verify user type - valid type
        return SystemController.getInstance().AddNewGame();
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
