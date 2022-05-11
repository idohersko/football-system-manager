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

        // happy flow
        Enums.ActionStatus status = controller.SetNewGame();
        assertEquals(" ", status, Enums.ActionStatus.SUCCESS);

    }
}
