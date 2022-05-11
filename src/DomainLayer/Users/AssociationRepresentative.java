package DomainLayer.Users;

import DomainLayer.Enums;
import DomainLayer.Games.League;

import java.util.Random;

public class AssociationRepresentative extends AUser {
//    public League league; todo - change in task 2 - no need this connection? in UC and in CD.


    public AssociationRepresentative(String name, String password) {
        super(name, password);
    }

    public static Enums.ActionStatus NewRefereeRegistration(String name, String email, Enums.RefereeLevel levelReferee)
    {

        //Registration to the system(DB) a new Referee, creating for referee userName and password to login and send an invitation to enter it.
        //todo add new referee to DB (use user controller?)
        //status -> will be return ActionStatus
        Enums.ActionStatus status = Enums.ActionStatus.SUCCESS;

        //create random password.
        String pwd = generatePassword(6);
        //create new User
        Random c1 = new Random();
        Random c2 = new Random();
        String userName = name + c1 + "xx" + c2;

        sendEmail(name ,email, userName ,pwd);
        return status;
    }

    public static boolean CheckRepresentativeLoggedIn(String RepresentativeName)
    {
        // todo implement - check that the given Representative is logged in in our DB
        return true;
    }


    private static String generatePassword(int length) {
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

    private static void sendEmail(String name, String email, String userName, String pwd) {
        /** An invitation was sent to 'name' as new referee in the System to email: 'email'
         Welcome!
         your use name: 'userName'
         your password: 'pwd'
         */
    }

    public static boolean CheckRepresentativeExists(String RepresentativeName)
    {
        // todo implement - check that the given Representative is exists
        return true;
    }
}
