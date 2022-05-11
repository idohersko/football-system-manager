package ServiceLayer;
import DataLayer.UsersDB;
import DomainLayer.Enums;
import java.util.Scanner;


//todo: start with some objects in our system DB - only what we need for our 3 UC
//todo : need only the needed characters , not all characters of the story
//todo : to each user - all attributes from the CD

// todo - compare to task 2 - write all differences at the end & read the story and make sure we did everything

//todo : Make sure there is at least one signed-in system admin (undergone a registration process).

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        UsersDB instance = UsersDB.getInstance();
        instance.getAll();
    }

}
