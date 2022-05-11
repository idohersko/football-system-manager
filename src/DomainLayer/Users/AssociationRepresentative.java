package DomainLayer.Users;

import DomainLayer.Enums;
import DomainLayer.Games.League;

public class AssociationRepresentative extends AUser {
    public League league;

    public AssociationRepresentative(String name, String password) {
        super(name, password);
    }

    public void NewRefereeRegistration(String refereeName)
    {
        // todo - set random password
        // todo The registration will be made by registering for the system and sending an invitation to enter it

        // todo - implement this function & add new referee to DB (use user controller?)
    }

    public void SetGamesSchedulePolicy(String refereeName)
    {
        // todo - implement if needed
    }
}
