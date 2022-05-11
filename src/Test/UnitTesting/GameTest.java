package Test.UnitTesting;

import DomainLayer.Enums;
import ServiceLayer.SystemController;
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

    @Test
    public void testGameScheduling() {
        //todo - add tests

        // happy flow - all parameters are OK
        Enums.ActionStatus status = controller.SetNewGame("Guy", "England", "01-01-2023",
                "Manchester", "Liverpool", "Manchester_Stadium");
        assertEquals(" ", status, Enums.ActionStatus.SUCCESS);

        // make sure we handled the case of null parameters - wrong input
        status = controller.SetNewGame(null, "England", "01-01-2023",
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
}
