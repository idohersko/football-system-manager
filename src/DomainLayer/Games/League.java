package DomainLayer.Games;
import DomainLayer.Users.AssociationRepresentative;

import java.util.ArrayList;

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
