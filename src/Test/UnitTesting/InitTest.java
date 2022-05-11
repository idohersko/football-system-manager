package Test.UnitTesting;

import ServiceLayer.SystemController;
import org.junit.*;


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
