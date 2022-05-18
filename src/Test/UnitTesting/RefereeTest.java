package Test.UnitTesting;

import DataLayer.UsersDB;
import DomainLayer.Enums;
import DomainLayer.Users.Referee;
import ServiceLayer.SystemController;
import org.junit.*;

import java.util.ArrayList;

import static DomainLayer.Users.AUser.getAllUsersFromDB;
import static org.junit.Assert.assertEquals;

public class RefereeTest {
    private SystemController controller;

    @Before
    public void initialize(){

        controller = SystemController.getInstance();
        try
        {
            UsersDB instance = UsersDB.getInstance();

            ArrayList<String> all_users = getAllUsersFromDB();
            for (String user : all_users) {
                String[] user_splitted = user.split(";");
                if (user_splitted[0].equals("NaamaBaruch")){
                    String passs = user_splitted[1];
                    Referee u = new Referee("NaamaBaruch",passs,Enums.ActivationStatus.ACTIVE,Enums.UserType.Referee,Enums.RefereeLevel.Primary);
                    instance.delete(u);

                }

            }
        }
        catch (Exception ignored){}
    }

    @Test
    public void testNewRefereeRegistration() {

        // happy flow
        Enums.ActionStatus status = controller.SignNewReferee("NaamaBaruch", "naamaBru123@post.ac.il", Enums.RefereeLevel.Secondary);
        assertEquals("Registration failed - should be a successful registration.", status, Enums.ActionStatus.SUCCESS);

        //Registration name who already exists in the system.
        status = controller.SignNewReferee("NaamaBaruch", "naamaBru@post.ac.il", Enums.RefereeLevel.Primary);
        assertEquals("This user should be is already registered in", status, Enums.ActionStatus.FAIL);
    }
    @Test
    public void testRegistrationNullArguments(){
        //check that we handled the case of null parameters - Wrong input
        Enums.ActionStatus status = controller.SignNewReferee("Naama",null, Enums.RefereeLevel.Secondary);
        assertEquals("Should be wrong in input parameters - email can't be null.", status, Enums.ActionStatus.WRONG_PARAMETERS);

        status = controller.SignNewReferee(null,"naamaBru123h@post.ac.il", Enums.RefereeLevel.Secondary);
        assertEquals("Should be wrong input parameters - name can't be null", status, Enums.ActionStatus.WRONG_PARAMETERS);

        status = controller.SignNewReferee("Liad","liad1313@post.ac.il", null);
        assertEquals("Should be wrong input parameters - level can't be null", status, Enums.ActionStatus.WRONG_PARAMETERS);
    }





}
