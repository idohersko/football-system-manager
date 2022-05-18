package ServiceLayer;

import DomainLayer.Enums;
import DomainLayer.Games.*;
import DomainLayer.Users.*;

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
        Enums.ActionStatus status = Enums.ActionStatus.SUCCESS;

        if(AssociationRepresentativeUserName == null || LeagueName == null || date == null || teamHomeName == null
        || teamGuestName == null || field == null)
        {
            return Enums.ActionStatus.WRONG_PARAMETERS;
        }

        boolean isExist = AssociationRepresentative.CheckRepresentativeExists(AssociationRepresentativeUserName);
        if(!isExist)
        {
            return Enums.ActionStatus.WRONG_PARAMETERS;
        }

        boolean isLogged = AssociationRepresentative.CheckRepresentativeLoggedIn(AssociationRepresentativeUserName);
        if(!isLogged)
        {
            return Enums.ActionStatus.FAIL;
        }

        boolean isLeagueExist = League.CheckLeagueExists(LeagueName);
        if(!isLeagueExist)
        {
            return Enums.ActionStatus.WRONG_PARAMETERS;
        }

        boolean isTeamExistWithLeague_home = Team.CheckTeamExistsWithTheLeague(teamHomeName, LeagueName);
        if(!isTeamExistWithLeague_home)
        {
            return Enums.ActionStatus.WRONG_PARAMETERS;
        }

        boolean isTeamExistWithLeague_guest = Team.CheckTeamExistsWithTheLeague(teamGuestName, LeagueName);
        if(!isTeamExistWithLeague_guest)
        {
            return Enums.ActionStatus.WRONG_PARAMETERS;
        }

        String refereeUserName = Referee.FindAvailableReferee();
        if(refereeUserName.equals(""))
        {
            return Enums.ActionStatus.FAIL;
        }
        ArrayList<String> referees = new ArrayList<>();
        referees.add(refereeUserName);
        return Game.AddNewGameToDB(date, "Current",field,teamHomeName,teamGuestName,referees);
    }


    public Enums.ActionStatus SignNewReferee(String name, String email, Enums.RefereeLevel levelReferee){
        if (name == null || email == null)
            return  Enums.ActionStatus.WRONG_PARAMETERS;

        if ((levelReferee != Enums.RefereeLevel.Primary) && (levelReferee != Enums.RefereeLevel.Secondary))
            return Enums.ActionStatus.WRONG_PARAMETERS;

        return AssociationRepresentative.NewRefereeRegistrationToDB(name, email,levelReferee);
    }

    public boolean VerifySystemAdmin()
    {
        return SystemAdmin.VerifySystemAdmin();
    }

}
