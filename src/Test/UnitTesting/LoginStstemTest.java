package Test.UnitTesting;
import DomainLayer.Enums;
import ServiceLayer.SystemController;
import org.junit.*;
import static org.junit.Assert.*;

public class LoginStstemTest {
    private SystemController controller;

    @Before
    public void initialize(){
        controller = SystemController.getInstance();
    }

    @Test
    public void testLogin(){
        // Login with existing userName and password - successful login
        Enums.ActionStatus status = controller.LogInUser("us-dar","dar123");
        assertEquals("Login failed - couldn't login the user", status, Enums.ActionStatus.SUCCESS);

        // Login with existing userName and password - but user is already login
        status = controller.LogInUser("us-dar","dar123");
        assertEquals("This user is already logged in", status, Enums.ActionStatus.FAIL);

        // make sure we handled the case of null parameters - wrong input
        status = controller.LogInUser(null,"dar123");
        assertEquals("Wrong input parameters - username can't be null", status, Enums.ActionStatus.WRONG_PARAMETERS);

        status = controller.LogInUser("us-dar",null);
        assertEquals("Wrong input parameters - password can't be null", status, Enums.ActionStatus.WRONG_PARAMETERS);

        // make sure we handled the case of wrong password for a given user
        status = controller.LogInUser("us-dar","111");
        assertEquals("Wrong input parameters - password doesn't match this user", status, Enums.ActionStatus.WRONG_PARAMETERS);

        // make sure we handled the case of wrong username input - user doesn't exist
        status = controller.LogInUser("da","dar123");
        assertEquals("Wrong input parameters - user does't exist", status, Enums.ActionStatus.WRONG_PARAMETERS);
    }
}
