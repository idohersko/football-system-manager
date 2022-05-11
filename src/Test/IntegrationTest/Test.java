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

        Enums.ActionStatus status = controller.LogInUser("Talya","sakov");
        assertEquals("failed - this test should have been success", status, Enums.ActionStatus.SUCCESS);

        status = controller.SetNewGame("Talya", "England", "01-01-2023",
                "Manchester", "Liverpool", "Manchester_Stadium");
        assertEquals("Failed - this test should have been success", status, Enums.ActionStatus.SUCCESS);
    }
}
