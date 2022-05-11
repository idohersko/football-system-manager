package DomainLayer.Users;

import DomainLayer.Enums;
import DomainLayer.Games.League;

public class AssociationRepresentative extends AUser {
//    public League league; todo - change in task 2 - no need this connection? in UC and in CD.

    public AssociationRepresentative(String name, String password) {
        super(name, password);
    }

    public void NewRefereeRegistration(String refereeName)
    {
        // todo - set random password
        // todo The registration will be made by registering for the system and sending an invitation to enter it

        // todo - implement this function & add new referee to DB (use user controller?)
    }

    public static boolean CheckRepresentativeLoggedIn(String RepresentativeName)
    {
        // todo implement - check that the given Representative is logged in in our DB
        return true;
    }
}
