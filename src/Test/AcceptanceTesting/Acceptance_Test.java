package Test.AcceptanceTesting;

import DataLayer.GamesDB;
import DataLayer.UsersDB;
import DomainLayer.Enums;
import DomainLayer.Games.Game;
import DomainLayer.Users.Referee;
import ServiceLayer.SystemController;
import org.junit.After;
import org.junit.Before;

import java.util.ArrayList;

import static DomainLayer.Games.Game.getAllGamesFromDB;
import static DomainLayer.Users.AUser.getAllUsersFromDB;
import static org.junit.Assert.assertEquals;

public class Acceptance_Test {
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


    @After
    public void deleteNewUser(){
        try
        {
            UsersDB instance = UsersDB.getInstance();

            ArrayList<String> all_users = getAllUsersFromDB();
            for (String user : all_users) {
                String[] user_splitted = user.split(";");
                if (user_splitted[0].equals("ref-ref")){
                    String passs = user_splitted[1];
                    Referee u = new Referee("ref-ref",passs,Enums.ActivationStatus.ACTIVE,Enums.UserType.Referee,Enums.RefereeLevel.Primary);
                    instance.delete(u);

                }

            }
        }
        catch (Exception ignored){}
    }

    @org.junit.Test
    public void testCompleteFlow() {
        //Test No. 25
        // Login with existing userName and password - successful login
        Enums.ActionStatus status = controller.LogInUser("us-dar","dar123");
        assertEquals("failed - this test should have been success", status, Enums.ActionStatus.SUCCESS);

        //Test No. 26
        // sign new referee
        status = controller.SignNewReferee("ref-ref", "ref-ref@tipo.ac.il", Enums.RefereeLevel.Primary);
        assertEquals("Registration failed - should be a successful registration.", status, Enums.ActionStatus.SUCCESS);

        //Test No. 27
        status = controller.SetNewGame("Talya", "England", "01-01-2023",
                "Manchester", "Liverpool", "Manchester_Stadium");
        assertEquals("Failed - this test should have been success", status, Enums.ActionStatus.SUCCESS);
    }

}
