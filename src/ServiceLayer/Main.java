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


    private static Enums.ActionStatus LogIn() {
        System.out.println("Please enter User-Name: ");
        String userName = sc.nextLine();
        System.out.println("Please enter User-Password: ");
        String userPassword = sc.nextLine();
        Enums.UserType userType = chooseUserTypeOptions();
        if(userType == null)
        {
            System.out.println("Invalid choice, restart Log-In process..");
        }
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

    private static boolean isNumber(String str) {
        for (char ch : str.toCharArray()) {
            if (!Character.isDigit(ch))
                return false;
        }
        return true;
    }

    private static int parseCheckInt(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return 1;
        }

        return 0;
    }

    private static int checkIfInt(String str, String message) {
        while (parseCheckInt(str) > 0) {
            System.out.println(message);
            Scanner scIn = new Scanner(System.in);
            str = scIn.nextLine();
        }
        return Integer.parseInt(str);
    }

    private static Enums.UserType chooseUserTypeOptions() {
        System.out.println("Please choose User-Type - the options are: ");
        System.out.println("1. Coach");
        System.out.println("2. Fan");
        System.out.println("3. Player");
        System.out.println("4. Referee");
        System.out.println("5. System Admin");
        System.out.println("6. Team Manager");
        System.out.println("7. Team Owner");
        String userType = sc.nextLine();
        if(!isNumber(userType))
        {
            return null;
        }
        int choice = Integer.parseInt(userType);
        if(choice<1 || choice>7)
        {
            return null;
        }
        return StringToUserType(choice);
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
