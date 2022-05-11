package DomainLayer.Users;

import DomainLayer.Enums;
import DomainLayer.Games.League;

public class AssociationRepresentative extends AUser {
    public League league;


    public AssociationRepresentative(String name, String password, Enums.UserType type, Enums.ActivationStatus activationStatus, League league) {
        super(name, password, type, activationStatus);
        this.league = league;
    }

    public void NewRefereeRegistration(String refereeName)
    {
        // todo - set random password
        // todo The registration will be made by registering for the system and sending an invitation to enter it

        // todo - implement this function & add new referee to DB (use user controller?)
    }
}
