package ServiceLayer;

import DomainLayer.Enums;
import DomainLayer.Users.AUser;
import DomainLayer.Users.AssociationRepresentative;
import DomainLayer.Users.SystemAdmin;

import java.util.ArrayList;

public class SystemController {
    private static SystemController systemControllerInstance;

    private SystemController() {
    }

    public static SystemController getInstance() {
        if (systemControllerInstance == null){
            systemControllerInstance = new SystemController();
        }
        return systemControllerInstance;
    }


    public Enums.ActionStatus LogInUser(String userName, String password){
        if(userName == null || password == null)
        {
            return Enums.ActionStatus.WRONG_PARAMETERS;
        }
        return AUser.LogInUserToDB(userName, password);
    }

    public Enums.ActionStatus SetNewGame(String AssociationRepresentativeUserName, String LeagueName, String date,
                                         String teamHomeName, String teamGuestName, String field)
    {
        if(AssociationRepresentativeUserName == null || LeagueName == null || date == null || teamHomeName == null
        || teamGuestName == null || field == null)
        {
            return Enums.ActionStatus.WRONG_PARAMETERS;
        }

        boolean isLogged = AssociationRepresentative.CheckRepresentativeLoggedIn(AssociationRepresentativeUserName);
        if(!isLogged)
        {
            return Enums.ActionStatus.FAIL; //add test for this case
        }

        // todo - make sure this league exists - add test
        // todo test of null aruuments
        // todo make sure the teams exsits and have this legaue - add test
        // todo - find referee that is available - test when we have no referees

        // todo - add the end - we have new game in games DB, the teams connedted to this game in their DB, referee also,
        // todo - send alert about the game to teams, referee and fans.

        // todo - add main success case

        return Enums.ActionStatus.SUCCESS;
    }

    public Enums.ActionStatus SignNewReferee()
    {
        //todo implement & update DB
        return Enums.ActionStatus.SUCCESS;
    }

    public boolean VerifySystemAdmin()
    {
        return SystemAdmin.VerifySystemAdmin();
    }

}
