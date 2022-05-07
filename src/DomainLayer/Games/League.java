package DomainLayer.Games;
import DomainLayer.Users.AssociationRepresentative;
import DomainLayer.Users.TeamOwner;

import java.util.ArrayList;
import java.util.HashMap;

public class League {
    public HashMap<Season, String> ScoreCalculationPolicy = new HashMap();
    public HashMap<Season, String> GamesSchedulingPolicy = new HashMap();
    public ArrayList<Season> seasons = new ArrayList<>();
    public ArrayList<Team> teams = new ArrayList<>();
    public ArrayList<AssociationRepresentative> associationRepresentatives = new ArrayList<>();

    public League(AssociationRepresentative associationRepresentative) {
        this.associationRepresentatives.add(associationRepresentative);
    }
}
