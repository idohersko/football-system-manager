package DomainLayer.Games;
import DomainLayer.Enums;
import DomainLayer.Users.AssociationRepresentative;

import java.util.ArrayList;
import java.util.HashMap;

public class League {
    public ArrayList<String> seasons = new ArrayList<>();
    public ArrayList<Team> teams = new ArrayList<>();
    public ArrayList<AssociationRepresentative> associationRepresentatives = new ArrayList<>();

    public League(AssociationRepresentative associationRepresentative) {
        this.associationRepresentatives.add(associationRepresentative);
    }

    public static boolean CheckLeagueExists(String LeagueName)
    {
        // todo implement - check that the League is exists
        return true;
    }
}
