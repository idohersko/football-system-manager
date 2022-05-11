package Test.UnitTesting;

import DomainLayer.Enums;
import ServiceLayer.SystemController;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.*;

public class InitTest {
    private SystemController controller;

    @Before
    public void initialize(){
        controller = SystemController.getInstance();
    }

    @Test
    public void testSystemAdmin() {
        Assert.assertTrue("You must have at least one signed-in system admin" , controller.VerifySystemAdmin());
    }

}
