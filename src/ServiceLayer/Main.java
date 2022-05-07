package ServiceLayer;

// todo: At least one system admin - must be a user (passed the registration process).
// todo : ask maxim on the main loop

import DomainLayer.Users.AUser;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        SystemController systemController = SystemController.getInstance();

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
                    SignIn(sc);
                    break;
                case 2:
                    logIn(sc);
                    break;
                case 3:
                    logOut(sc);
                    break;
                case 4:
                    SignNewReferee(sc);
                    break;
                case 5:
                    AddNewGame(sc);
                    break;
                default:
                    System.out.println("Please enter a valid number (between 0-5), by the followed menu");
            }
            System.out.println("\nWhat would you like to do next ?\n");
            printMenu();
            choiceStr = sc.nextLine();
            if (isNumber(choiceStr)) {
                choice = checkIfInt(choiceStr,"Please enter a valid option : ");
            }
        }
        System.out.println("Goodbye! See you soon..");
    }

    private static void SignIn(Scanner sc) {
        //todo add check if this userName already exist - only one user per user name!

        //todo implement
    }

    private static void logIn(Scanner sc) {
        //todo add check if this userName exist - only signed user can log in!
        System.out.println("Please enter User-Name: ");
        String userName = sc.nextLine();
        System.out.println("Please enter User-Password: ");
        String userPassword = sc.nextLine();
        System.out.println("Please enter User-Type: "); //todo add option to choose from
        String userType = sc.nextLine();
        SystemController.LogIn(userName, userPassword, userType);
    }

    private static void logOut(Scanner sc) {
        //todo add check if this userName exist and active - only active logged in user can log out!
        System.out.println("Please enter User-Name: ");
        String userName = sc.nextLine();
        SystemController.LogOut(userName);
    }

    private static void SignNewReferee(Scanner sc) {
        //todo verify user type - valid type
        SystemController.SignNewReferee();
    }

    private static void AddNewGame(Scanner sc) {
        //todo verify user type - valid type
        SystemController.AddNewGame();
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
        System.out.println("1. SignIn");
        System.out.println("2. Login");
        System.out.println("3. Logout");
        System.out.println("4. Registration of a new referee");
        System.out.println("5. Add new game");
        System.out.println("0. Close system");
    }
}
