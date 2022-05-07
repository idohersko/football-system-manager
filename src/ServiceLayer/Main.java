package ServiceLayer;

// todo: At least one system admin - must be a user (passed the registration process).
// todo : ask maxim on the main loop

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        SystemController systemController = SystemController.getInstance();

        Scanner sc = new Scanner(System.in);
        System.out.println("Hello, and welcome to our Football System!\n");
        System.out.println("Please select your desired action: ");
        System.out.println("1. Login");
        System.out.println("2. Logout");
        System.out.println("3. Registration of a new referee");
        System.out.println("4. Add new game");
        System.out.println("0. Close system");

        String choiceStr = sc.nextLine();
        int choice = 100;
        if (isNumber(choiceStr)) {
            choice = checkIfInt(choiceStr, "Please enter a valid option : ");
        } else {
            System.out.println("You have typed a wrong input.");
            System.out.println("Please enter a number, by the followed menu");
        }
        while (choice != 0) {
            Scanner scIn = new Scanner(System.in);
            switch (choice) {
                case 1:
                    SystemController.LogIn();
                    break;
                case 2:
                    SystemController.LogOut();
                    break;
                case 3:
                    SystemController.SignNewReferee();
                    break;
                case 4:
                    SystemController.AddNewGame();
                    break;
                default:
                    System.out.println("Please enter a valid number (between 0-4), by the followed menu");
            }
            System.out.println("\nWhat would you like to do next ?\n");
            System.out.println("Please select your desired action: ");
            System.out.println("1. Login");
            System.out.println("2. Logout");
            System.out.println("3. Registration of a new referee");
            System.out.println("4. Add new game");
            System.out.println("0. Close system");
            choiceStr = sc.nextLine();
            if (isNumber(choiceStr)) {
                choice = checkIfInt(choiceStr,"Please enter a valid option : ");
            }
        }
        System.out.println("Goodbye! See you soon..");
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
}
