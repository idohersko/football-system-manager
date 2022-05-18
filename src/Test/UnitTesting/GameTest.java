package Test.UnitTesting;

import DataLayer.GamesDB;
import DataLayer.UsersDB;
import DomainLayer.Enums;
import DomainLayer.Games.Game;
import DomainLayer.Users.Referee;
import ServiceLayer.SystemController;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static DomainLayer.Users.AUser.getAllUsersFromDB;

import java.util.ArrayList;

import static DomainLayer.Games.Game.getAllGamesFromDB;
import static org.junit.Assert.assertEquals;

public class GameTest {
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

    @Test

    public void testGameSchedulingHappyFlow() {
        // happy flow - all parameters are OK
        //Test No. 11
        Enums.ActionStatus status = controller.SetNewGame("Talya", "England", "01-01-2023",
                "Manchester", "Liverpool", "Manchester_Stadium");
        assertEquals("Failed - this test should have been success", status, Enums.ActionStatus.SUCCESS);
    }

    @Test
    public void testGameSchedulingNullArguments() {
        //Test No. 12
        // make sure we handled the case of null parameters - wrong input
        Enums.ActionStatus status = controller.SetNewGame(null, "England", "01-01-2023",
                "Manchester", "Liverpool", "Manchester_Stadium");
        assertEquals("Wrong input parameters - the values can't be null", status, Enums.ActionStatus.WRONG_PARAMETERS);
//Test No. 13
        status = controller.SetNewGame("Guy", null, "01-01-2023",
                "Manchester", "Liverpool", "Manchester_Stadium");
        assertEquals("Wrong input parameters - the values can't be null", status, Enums.ActionStatus.WRONG_PARAMETERS);
//Test No. 14
        status = controller.SetNewGame("Guy", "England", null,
                "Manchester", "Liverpool", "Manchester_Stadium");
        assertEquals("Wrong input parameters - the values can't be null", status, Enums.ActionStatus.WRONG_PARAMETERS);
//Test No. 15
        status = controller.SetNewGame("Guy", "England", "01-01-2023",
                null, "Liverpool", "Manchester_Stadium");
        assertEquals("Wrong input parameters - the values can't be null", status, Enums.ActionStatus.WRONG_PARAMETERS);
//Test No. 16
        status = controller.SetNewGame("Guy", "England", "01-01-2023",
                "Manchester", null, "Manchester_Stadium");
        assertEquals("Wrong input parameters - the values can't be null", status, Enums.ActionStatus.WRONG_PARAMETERS);
//Test No. 17
        status = controller.SetNewGame("Guy", "England", "01-01-2023",
                "Manchester", "Liverpool", null);
        assertEquals("Wrong input parameters - the values can't be null", status, Enums.ActionStatus.WRONG_PARAMETERS);

    }

    @Test
    public void testGameSchedulingWrongInput() {
        //Test No. 18
        // AssociationRepresentative isn't exist - should fail
        Enums.ActionStatus status = controller.SetNewGame("Dar", "England", "01-01-2023",
                "Manchester", "Liverpool", "Manchester_Stadium");
        assertEquals("should be \"WRONG_PARAMETERS\"- Association Representative isn't exist", status, Enums.ActionStatus.WRONG_PARAMETERS);

        //Test No. 19
        // AssociationRepresentative logged out - should fail
        status = controller.SetNewGame("Ido", "England", "01-01-2023",
                "Manchester", "Liverpool", "Manchester_Stadium");
        assertEquals("should fail - Association Representative must log in first", status, Enums.ActionStatus.FAIL);

        //Test No. 20
        // League isn't exist - should fail
        status = controller.SetNewGame("Talya", "Naama", "01-01-2023",
                "Manchester", "Liverpool", "Manchester_Stadium");
        assertEquals("should be \"WRONG_PARAMETERS\"", status, Enums.ActionStatus.WRONG_PARAMETERS);

        //Test No. 21
        // Team isn't exist - should fail
        status = controller.SetNewGame("Talya", "England", "01-01-2023",
                "Maxim", "Liverpool", "Manchester_Stadium");
        assertEquals("should be \"WRONG_PARAMETERS\"-", status, Enums.ActionStatus.WRONG_PARAMETERS);

        //Test No. 22
        // Team has other League - should fail
        status = controller.SetNewGame("Talya", "UK", "01-01-2023",
                "Manchester", "Liverpool", "Manchester_Stadium");
        assertEquals("should be \"WRONG_PARAMETERS\"-", status, Enums.ActionStatus.WRONG_PARAMETERS);

    }
}
