package Test.UnitTesting;

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
        controller.LogIn("us-dar","dar123","Fan");
        assertFalse(controller.getUsers().isEmpty());
        assertEquals(1, controller.getUsers().size());

        //todo one of the parameter is null - wrong val password
        try {
            controller.LogIn("us-dar",null,"Fan");
        }catch (Exception e) {
            System.out.println("WrongPassword");
        }
        //todo Wrong password
        try {
            controller.LogIn("us-dar","111","Fan");
        }catch (Exception e) {
            System.out.println("WrongPassword");
        }
        //todo User name does not exist
        try {
            controller.LogIn("da","dar123","Fan");
        }catch (Exception e) {
            System.out.println("UserNameDoesNotExist- wrong password typed");
        }
    }




}
