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
    public void testNewRefereeRegistration(){
        // happy flow
        Enums.ActionStatus status = controller.SignNewReferee("NammaBaruch","naamaBru123@post.ac.il", Enums.RefereeLevel.Secondary);
        assertEquals("Registration failed", status, Enums.ActionStatus.SUCCESS);

        // check that we handled the case of null parameters - wrong input
        status = controller.SignNewReferee("NaamaBaruch","", Enums.RefereeLevel.Primary);
        assertEquals("Wrong input parameters - email can't be null", status, Enums.ActionStatus.WRONG_PARAMETERS);

        status = controller.SignNewReferee("","naamaBru123h@post.ac.il", Enums.RefereeLevel.Primary);
        assertEquals("Wrong input parameters - name can't be null", status, Enums.ActionStatus.WRONG_PARAMETERS);

        // check that we handled the case of unknown level - wrong input
        status = controller.SignNewReferee("NammaBaruch","naamaBru123@post.ac.il", null);
        assertEquals("Wrong input parameters - level can't be null", status, Enums.ActionStatus.WRONG_PARAMETERS);

        // check that we handle the case of legal email, example:'@'
        status = controller.SignNewReferee("NammaBaruch","naamaBru123post.ac.il", Enums.RefereeLevel.Secondary);
        assertEquals("Wrong input parameters - illegal email without '@'", status, Enums.ActionStatus.WRONG_PARAMETERS);

        // Register referee that existing already in the system -  referee already registered.
        status = controller.SignNewReferee("NammaBaruch","naamaBru123@post.ac.il", Enums.RefereeLevel.Secondary);
        assertEquals("This user is already registered in", status, Enums.ActionStatus.FAIL);

    }





}
