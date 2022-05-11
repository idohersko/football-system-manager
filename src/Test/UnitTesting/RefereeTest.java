package Test.UnitTesting;

import DomainLayer.Enums;
import ServiceLayer.SystemController;
import org.junit.*;
import static org.junit.Assert.assertEquals;

public class RefereeTest {
    private SystemController controller;

    @Before
    public void initialize(){
        controller = SystemController.getInstance();
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
