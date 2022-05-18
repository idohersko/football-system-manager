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
        // Login with existing userName and password - successful login
        Enums.ActionStatus status = controller.LogInUser("us-dar","dar123");
        assertEquals("failed - this test should have been success", status, Enums.ActionStatus.SUCCESS);
    }

    @Test
    public void testLoginNullArguments(){
        // make sure we handled the case of null parameters - wrong input
        Enums.ActionStatus status = controller.LogInUser(null,"dar123");
        assertEquals("Wrong input parameters - username can't be null", status, Enums.ActionStatus.WRONG_PARAMETERS);

        status = controller.LogInUser("us-dar",null);
        assertEquals("Wrong input parameters - password can't be null", status, Enums.ActionStatus.WRONG_PARAMETERS);
    }

    @Test
    public void testLoginWrongInput(){
        // make sure we handled the case of wrong password for a given user
        Enums.ActionStatus status = controller.LogInUser("us-dar","111");
        assertEquals("Wrong input parameters - password doesn't match this user", status, Enums.ActionStatus.FAIL);

        // make sure we handled the case of wrong username input - user doesn't exist
        status = controller.LogInUser("da","dar123");
        assertEquals("Wrong input parameters - user does't exist", status, Enums.ActionStatus.FAIL);
    }
}
