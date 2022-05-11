package Test.UnitTesting;

import DomainLayer.Enums;
import ServiceLayer.SystemController;
import org.junit.*;
import static org.junit.Assert.*;

public class SystemControllerTest {
    private SystemController controller;

    @Before
    public void initialize(){
        controller = SystemController.getInstance();
        //todo need to SignUp to the System first.
        //controller.SignIn("us-dar","dar123","Fan");
    }

    @Test
    public void testLogin(){
        //login with existing userName and password - successful login
        //todo successful login
        controller.LogInUser("us-dar","dar123", Enums.UserType.Fan);
        assertFalse(controller.GetAllSystemUsernames().isEmpty());
        assertEquals(1, controller.GetAllSystemUsernames().size());

        //todo one of the parameter is null - wrong val password
        try {
            controller.LogInUser("us-dar",null,Enums.UserType.Fan);
        }catch (Exception e) {
            System.out.println("WrongPassword");
        }
        //todo Wrong password
        try {
            controller.LogInUser("us-dar","111",Enums.UserType.Fan);
        }catch (Exception e) {
            System.out.println("WrongPassword");
        }
        //todo User name does not exist
        try {
            controller.LogInUser("da","dar123",Enums.UserType.Fan);
        }catch (Exception e) {
            System.out.println("UserNameDoesNotExist- wrong password typed");
        }
    }

    @Test
    public void testLogout(){
        // todo implement
    }




}
