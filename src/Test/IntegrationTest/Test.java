package Test.IntegrationTest;

import DomainLayer.Enums;
import ServiceLayer.SystemController;
import org.junit.Assert;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class Test {
    private SystemController controller;

    @Before
    public void initialize(){
        controller = SystemController.getInstance();
    }

    @org.junit.Test
    public void TestLoginAndAddGame() {
        // Login with existing userName and password - successful login

        Enums.ActionStatus status = controller.LogInUser("Ido","id123");
        assertEquals("failed - this test should have been success", status, Enums.ActionStatus.SUCCESS);

        status = controller.SignNewReferee("NammaBaruch","naamaBru123@post.ac.il", Enums.RefereeLevel.Secondary);
        assertEquals("Registration failed - should be a successful registration.", status, Enums.ActionStatus.SUCCESS);
    }
}
