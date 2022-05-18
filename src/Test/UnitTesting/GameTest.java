package Test.UnitTesting;

import DomainLayer.Enums;
import ServiceLayer.SystemController;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {
    private SystemController controller;

    @Before
    public void initialize(){

        controller = SystemController.getInstance();
    }

    @After
    public void deleteNewGame(){
        controller = SystemController.getInstance();
    }

    @Test
    public void testGameSchedulingHappyFlow() {
        // happy flow - all parameters are OK
        Enums.ActionStatus status = controller.SetNewGame("Talya", "England", "01-01-2023",
                "Manchester", "Liverpool", "Manchester_Stadium");
        assertEquals("Failed - this test should have been success", status, Enums.ActionStatus.SUCCESS);
    }

    @Test
    public void testGameSchedulingNullArguments() {
        // make sure we handled the case of null parameters - wrong input
        Enums.ActionStatus status = controller.SetNewGame(null, "England", "01-01-2023",
                "Manchester", "Liverpool", "Manchester_Stadium");
        assertEquals("Wrong input parameters - the values can't be null", status, Enums.ActionStatus.WRONG_PARAMETERS);

        status = controller.SetNewGame("Guy", null, "01-01-2023",
                "Manchester", "Liverpool", "Manchester_Stadium");
        assertEquals("Wrong input parameters - the values can't be null", status, Enums.ActionStatus.WRONG_PARAMETERS);

        status = controller.SetNewGame("Guy", "England", null,
                "Manchester", "Liverpool", "Manchester_Stadium");
        assertEquals("Wrong input parameters - the values can't be null", status, Enums.ActionStatus.WRONG_PARAMETERS);

        status = controller.SetNewGame("Guy", "England", "01-01-2023",
                null, "Liverpool", "Manchester_Stadium");
        assertEquals("Wrong input parameters - the values can't be null", status, Enums.ActionStatus.WRONG_PARAMETERS);

        status = controller.SetNewGame("Guy", "England", "01-01-2023",
                "Manchester", null, "Manchester_Stadium");
        assertEquals("Wrong input parameters - the values can't be null", status, Enums.ActionStatus.WRONG_PARAMETERS);

        status = controller.SetNewGame("Guy", "England", "01-01-2023",
                "Manchester", "Liverpool", null);
        assertEquals("Wrong input parameters - the values can't be null", status, Enums.ActionStatus.WRONG_PARAMETERS);

    }

    @Test
    public void testGameSchedulingWrongInput() {
        // AssociationRepresentative isn't exist - should fail
        Enums.ActionStatus status = controller.SetNewGame("Dar", "England", "01-01-2023",
                "Manchester", "Liverpool", "Manchester_Stadium");
        assertEquals("should be \"WRONG_PARAMETERS\"- Association Representative isn't exist", status, Enums.ActionStatus.WRONG_PARAMETERS);

        // AssociationRepresentative logged out - should fail
        status = controller.SetNewGame("Ido", "England", "01-01-2023",
                "Manchester", "Liverpool", "Manchester_Stadium");
        assertEquals("should fail - Association Representative must log in first", status, Enums.ActionStatus.FAIL);

        // League isn't exist - should fail
        status = controller.SetNewGame("Talya", "Naama", "01-01-2023",
                "Manchester", "Liverpool", "Manchester_Stadium");
        assertEquals("should be \"WRONG_PARAMETERS\"", status, Enums.ActionStatus.WRONG_PARAMETERS);

        // Team isn't exist - should fail
        status = controller.SetNewGame("Talya", "England", "01-01-2023",
                "Maxim", "Liverpool", "Manchester_Stadium");
        assertEquals("should be \"WRONG_PARAMETERS\"-", status, Enums.ActionStatus.WRONG_PARAMETERS);

        // Team has other League - should fail
        status = controller.SetNewGame("Talya", "UK", "01-01-2023",
                "Manchester", "Liverpool", "Manchester_Stadium");
        assertEquals("should be \"WRONG_PARAMETERS\"-", status, Enums.ActionStatus.WRONG_PARAMETERS);

    }
}
