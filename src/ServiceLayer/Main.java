package ServiceLayer;
import DataLayer.UsersDB;
import DomainLayer.Enums;
import DomainLayer.Users.AUser;
import DomainLayer.Users.Referee;

import java.sql.SQLException;
import java.util.Scanner;


//todo: start with some objects in our system DB - only what we need for our 3 UC
//todo : need only the needed characters , not all characters of the story
//todo : to each user - all attributes from the CD

// todo - compare to task 2 - write all differences at the end & read the story and make sure we did everything

//todo : Make sure there is at least one signed-in system admin (undergone a registration process).

// todo - add to DB all what we have in our tests

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        Referee ref = new Referee("naama","naama123", Enums.ActivationStatus.ACTIVE,Enums.UserType.Referee,Enums.RefereeLevel.Primary);
        UsersDB instance = UsersDB.getInstance();
        System.out.println(instance.getAll());
        //instance.save(ref);
        String[] params = new String[]{"naama","naama!!!",Enums.ActivationStatus.INACTIVE.toString(),Enums.RefereeLevel.Primary.toString()};
        instance.update(ref,params);
        System.out.println(instance.getAll());

        //instance.save(ref);
    }

}
