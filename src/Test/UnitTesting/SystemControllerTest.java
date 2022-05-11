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
    }

    @Test
    public void testLogin(){
        // Login with existing userName and password - successful login
        try {
            controller.LogInUser("us-dar","dar123");
        }catch (Exception e) {
            // todo - don't print - make sure we got an error

            System.out.println(e.getMessage());
        }

        // make sure our users list isn't empty
        assertFalse(controller.GetAllSystemUsernames().isEmpty());

        // make sure we handled the case of null parameters - wrong input
        try {
            controller.LogInUser(null,"dar123");
        }catch (Exception e) {
            // todo - don't print - make sure we got an error

            System.out.println(e.getMessage());
        }
        try {
            controller.LogInUser("us-dar",null);
        }catch (Exception e) {
            // todo - don't print - make sure we got an error

            System.out.println(e.getMessage());
        }

        // make sure we handled the case of wrong password for a given user
        try {
            controller.LogInUser("us-dar","111");
        }catch (Exception e) {
            // todo - don't print - make sure we got an error

            System.out.println(e.getMessage());
        }

        // make sure we handled the case of wrong username input - user doesn't exist
        try {
            controller.LogInUser("da","dar123");
        }catch (Exception e) {
            // todo - don't print - make sure we got an error

            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testLogout(){
        // Logout with logged-in user - successful logout
        try {
            controller.LogOutUser("us-dar");
        }catch (Exception e) {
            // todo - don't print - make sure we got an error

            System.out.println(e.getMessage());
        }

        // make sure we handled the case of null parameters - wrong input
        try {
            controller.LogOutUser(null);
        }catch (Exception e) {
            // todo - don't print - make sure we got an error

            System.out.println(e.getMessage());
        }

        // make sure we handled the case of user that is already logged out
        try {
            controller.LogOutUser("us-dar");
        }catch (Exception e) {
            // todo - don't print - make sure we got an error

            System.out.println(e.getMessage());
        }

        // make sure we handled the case of wrong username input - user doesn't exist
        try {
            controller.LogOutUser("da");
        }catch (Exception e) {
            // todo - don't print - make sure we got an error

            System.out.println(e.getMessage());
        }
    }




}
