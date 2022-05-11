package DomainLayer.Games;
import DomainLayer.Enums;
import DomainLayer.Users.AssociationRepresentative;

import java.util.ArrayList;
import java.util.HashMap;


public class League {
    //public ArrayList<Season> seasons = new ArrayList<>();
    public ArrayList<Team> teams = new ArrayList<>();
    public ArrayList<AssociationRepresentative> associationRepresentatives = new ArrayList<>();

    public League(AssociationRepresentative associationRepresentative) {
        this.associationRepresentatives.add(associationRepresentative);
    }
}
