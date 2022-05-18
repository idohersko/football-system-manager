package DomainLayer.Users;

import DataLayer.UsersDB;
import DomainLayer.Enums;
import DomainLayer.Games.League;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Random;

public class AssociationRepresentative extends AUser {

    public AssociationRepresentative(String name, String password, Enums.ActivationStatus status, Enums.UserType userType) {
        super(name, password, status, userType);
    }

    public static Enums.ActionStatus NewRefereeRegistrationToDB(String userName, String email, Enums.RefereeLevel levelReferee){

        //Registration to the system(DB) a new Referee, creating for referee password to login and send an invitation to enter it.
        ArrayList<String> all_users = getAllUsersFromDB();

        // check if user exists, if no return exception.
        for (String user : all_users) {
            String[] user_splitted = user.split(";");
            if (user_splitted[0].equals(userName))
                return Enums.ActionStatus.FAIL;
        }
        //else - we create new referee and give him random password for login to system.
        String pwd = generatePassword(6);

        // write to DB - add new referee.
        UsersDB usersDB = UsersDB.getInstance();
        try {
            usersDB.save(new Referee(userName, pwd, Enums.ActivationStatus.INACTIVE, Enums.UserType.Referee, levelReferee));
        }
        catch (Exception e) {
            return Enums.ActionStatus.FAIL;
        }
        sendEmail(userName, email, pwd);
        return Enums.ActionStatus.SUCCESS;

    }

    public static boolean CheckRepresentativeLoggedIn(String RepresentativeName)
    {
        // check that the given Representative is logged-in in our DB

        ArrayList<String> all_users = getAllUsersFromDB();

        for (String user: all_users) {
            String[] user_splitted = user.split(";");
            if(user_splitted[0].equals(RepresentativeName))
            {
                if(user_splitted[2].equals(Enums.ActivationStatus.ACTIVE.toString()))
                {
                    return true;
                }
                return false;
            }
        }
        return false;
    }


    private static String generatePassword(int length){
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
        Random random = new Random();
        String password = "";

        password += lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        password += numbers.charAt(random.nextInt(numbers.length()));
        password += capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        password += specialCharacters.charAt(random.nextInt(specialCharacters.length()));

        for(int i = 4; i< length ; i++) {
            password += combinedChars.charAt(random.nextInt(combinedChars.length()));
        }
        return password;
    }

    private static void sendEmail(String userName, String email, String pwd) {
        /**
         output: An invitation was sent to 'name' as new referee in the System to email: 'email'
                 Welcome!
                 your use name: 'userName'
                 your password: 'pwd'
         */
    }

    public static boolean CheckRepresentativeExists(String RepresentativeName)
    {
        // make sure that this Representative exists (return true if 'yes', false if 'not')
        ArrayList<String> all_users = getAllUsersFromDB();

        for (String user: all_users) {
            String[] user_splitted = user.split(";");
            if(user_splitted[0].equals(RepresentativeName))
            {
                if(user_splitted[2].equals(Enums.UserType.AssociationRepresentative.toString()))
                {
                    return true;
                }
                return false;
            }
        }
        return false;
    }
}
