package Test.UnitTesting;
import DomainLayer.Enums;
import ServiceLayer.SystemController;
import org.junit.*;
import static org.junit.Assert.*;

public class LoginSystemTest {
    private SystemController controller;

    @Before
    public void initialize(){
        controller = SystemController.getInstance();
    }

    @Test
    public void testLoginHappyFlow() {
        //Test No. 1
        // Login with existing userName and password - successful login
        Enums.ActionStatus status = controller.LogInUser("us-dar","dar123");
        assertEquals("failed - this test should have been success", status, Enums.ActionStatus.SUCCESS);
    }

    @Test
    public void testLoginNullArguments(){
        //Test No. 2
        // make sure we handled the case of null parameters - wrong input
        Enums.ActionStatus status = controller.LogInUser(null,"dar123");
        assertEquals("Wrong input parameters - username can't be null", status, Enums.ActionStatus.WRONG_PARAMETERS);
        //Test No. 3
        status = controller.LogInUser("us-dar",null);
        assertEquals("Wrong input parameters - password can't be null", status, Enums.ActionStatus.WRONG_PARAMETERS);
    }

    @Test
    public void testLoginWrongInput(){
        //Test No. 4
        // make sure we handled the case of wrong password for a given user
        Enums.ActionStatus status = controller.LogInUser("us-dar","111");
        assertEquals("Wrong input parameters - password doesn't match this user", status, Enums.ActionStatus.FAIL);
        //Test No. 5
        // make sure we handled the case of wrong username input - user doesn't exist
        status = controller.LogInUser("da","dar123");
        assertEquals("Wrong input parameters - user does't exist", status, Enums.ActionStatus.FAIL);
    }
}
