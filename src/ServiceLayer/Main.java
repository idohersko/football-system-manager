package ServiceLayer;

// todo: At least one system admin - must be a user (passed the registration process).
// todo : ask maxim on the main loop  , and if it's ok to start with some objects in the system

//todo - add guest handler

//todo test all cases! include wrong input parameters

import DomainLayer.Enums;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //todo : At this point make sure there is at least one signed-in system admin (undergone a registration process).

        SystemController systemController = SystemController.getInstance();

        System.out.println("Hi guest! welcome to out Football System");

        Scanner sc = new Scanner(System.in);
        printMenu();

        String choiceStr = sc.nextLine();
        int choice = 100;
        if (isNumber(choiceStr)) {
            choice = checkIfInt(choiceStr, "Please enter a valid option : ");
        } else {
            System.out.println("You have typed a wrong input.");
            System.out.println("Please enter a number, by the followed menu");
        }
        while (choice != 0) {
            switch (choice) {
                case 1:
                    SignInGuestAsFan(sc);
                    break;
                case 2:
                    logIn(sc);
                    break;
                case 3:
                    logOut(sc);
                    break;
                case 4:
                    LogInGuestAsEmployee(sc);
                    break;
                case 5:
                    SignNewReferee(sc);
                    break;
                case 6:
                    AddNewGame(sc);
                    break;
                default:
                    System.out.println("Please enter a valid number (between 0-6), by the followed menu");
            }
            System.out.println("\nWhat would you like to do next ?\n");
            printMenu();
            choiceStr = sc.nextLine();
            if (isNumber(choiceStr)) {
                choice = checkIfInt(choiceStr,"Please enter a valid option : ");
            }}
        System.out.println("Goodbye! See you soon..");
    }

    private static void SignInGuestAsFan(Scanner sc) {
        System.out.println("Please choose User-Name: ");
        String userName = sc.nextLine();
        System.out.println("Please choose User-Password: ");
        String userPassword = sc.nextLine();
        Enums.ActionStatus status = SystemController.getInstance().SignInGuest(userName, userPassword, Enums.UserType.Fan);
        ResponseToActionStatus(status);
    }

    private static void logIn(Scanner sc) {
        System.out.println("Please enter User-Name: ");
        String userName = sc.nextLine();
        System.out.println("Please enter User-Password: ");
        String userPassword = sc.nextLine();
        Enums.UserType userType = chooseUserTypeOptions(sc);
        if(userType == null)
        {
            System.out.println("Invalid choice, restart Log-In process..");
        }
        Enums.ActionStatus status = SystemController.getInstance().LogIn(userName, userPassword, userType);
        ResponseToActionStatus(status);
    }


    private static void LogInGuestAsEmployee(Scanner sc) {
        System.out.println("Please enter User-Name: ");
        String userName = sc.nextLine();
        System.out.println("Please enter User-Password: ");
        String userPassword = sc.nextLine();
        Enums.UserType userType = chooseUserTypeOptions(sc);
        if(userType == null)
        {
            System.out.println("Invalid choice, restart Log-In process..");
        }
        Enums.ActionStatus status = SystemController.getInstance().LogIn(userName, userPassword, userType);
        ResponseToActionStatus(status);
    }

    private static void logOut(Scanner sc) {
        System.out.println("Please enter User-Name: ");
        String userName = sc.nextLine();
        Enums.ActionStatus status = SystemController.getInstance().LogOut(userName);
        ResponseToActionStatus(status);
    }

    private static void SignNewReferee(Scanner sc) {
        //todo verify user type - valid type
        Enums.ActionStatus status = SystemController.getInstance().SignNewReferee();
        ResponseToActionStatus(status);
    }

    private static void AddNewGame(Scanner sc) {
        //todo verify user type - valid type
        Enums.ActionStatus status = SystemController.getInstance().AddNewGame();
        ResponseToActionStatus(status);
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

    private static void printMenu() {
        System.out.println("Please select your desired action: ");
        System.out.println("1. Sign in as dear Fan");
        System.out.println("2. Log in as a Fan");
        System.out.println("3. Log in as an employee");
        System.out.println("4. Log out");
        System.out.println("5. Registration of a new referee");
        System.out.println("6. Add new game");
        System.out.println("0. Close system");
    }

    private static Enums.UserType chooseUserTypeOptions(Scanner sc) {
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

    private static void ResponseToActionStatus(Enums.ActionStatus actionStatus) {
        if(actionStatus == Enums.ActionStatus.SUCCESS)
        {
            System.out.println("Your request completed successfully");
        }
        else
        {
            System.out.println("Operation failed, please restart");
        }

    }
}
