package Test.IntegrationTest;

import DataLayer.GamesDB;
import DataLayer.RefereesDB;
import DataLayer.UsersDB;
import DomainLayer.Enums;
import DomainLayer.Games.Game;
import ServiceLayer.SystemController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.*;


import java.util.ArrayList;

import static DomainLayer.Games.Game.getAllGamesFromDB;
import static DomainLayer.Users.AUser.getAllUsersFromDB;
import static org.junit.Assert.assertEquals;

public class Integration_Test {
    private SystemController controller;

    @Before
    public void initialize(){
        controller = SystemController.getInstance();
        try
        {
            GamesDB instance = GamesDB.getInstance();

            ArrayList<String> all_games = getAllGamesFromDB();
            for (String game : all_games) {
                String[] game_splitted = game.split(";");
                if (game_splitted[0].equals("Manchester") && game_splitted[1].equals("Liverpool")
                        && game_splitted[2].equals("01-01-2023")){
                    Game game_tmp = new Game("01-01-2023", "Current", "Manchester_Stadium", "Manchester", "Liverpool", null);
                    instance.delete(game_tmp);
                }
            }
        }
        catch (Exception ignored){}
    }

    @org.junit.Test
    public void TestLoginAndAddGame() {
        //Test No. 23
        // Login with existing userName and password - successful login

        Enums.ActionStatus status = controller.LogInUser("Talya","sakov");
        status = controller.SetNewGame("Talya", "England", "01-01-2023",
                "Manchester", "Liverpool", "Manchester_Stadium");
        assertEquals("Failed - this test should have been success", status, Enums.ActionStatus.SUCCESS);
    }

    @org.junit.Test
    public void TestLoginAndRegisterNewReferee() {
        //Test No. 24
        //Login with existing referee with userName and password and then try to register as new one.
        controller.LogInUser("referee_2","12345_r1");
        Enums.ActionStatus status = controller.SignNewReferee("referee_2", "referee_2@post.ac.il", Enums.RefereeLevel.Primary);
        assertEquals("failed - the user should be exist already in the system.", status, Enums.ActionStatus.FAIL);
    }
}
