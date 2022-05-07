package DomainLayer.Users;

import DomainLayer.Games.League;

public class AssociationRepresentative extends AUser {
    public League league;

    public AssociationRepresentative(League league) {
        this.league = league;
    }
}
