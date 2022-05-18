package DataLayer;

import DomainLayer.Games.League;
import DomainLayer.Games.Team;
import DomainLayer.Users.AssociationRepresentative;
import org.sqlite.util.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LeaguesDB implements DB<League> {
    private static final LeaguesDB instance = new LeaguesDB();
    private Connection connection;

    //private constructor to avoid client applications to use constructor
    public static LeaguesDB getInstance(){
        return instance;
    }

    //private constructor
    private LeaguesDB() {
        this.connection = DBConnector.getConnection();
    }
    @Override
    public String get(String name) {

        try
        {
            String query = "Select * from leagues where name = ?";

            // Prepare Statement
            PreparedStatement myStmt = connection.prepareStatement(query);

            // Set Parameters
            myStmt.setString(1, name);

            // Execute SQL query
            ResultSet rs = myStmt.executeQuery();

            // Display function to show the Resultset
            String answer = "";
            while (rs.next()) {
                String league_name = rs.getString("name");
                String league_season = rs.getString("season");
                String league_teams = rs.getString("teams"); //separates by ','
                String league_association_representative = rs.getString("association-representative");

                answer = league_name + ";" + league_season + ";" + league_teams +";"+league_association_representative;
            }
            return answer;

        }
        catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }

    }

    @Override
    public ArrayList<String> getAll() {
        ArrayList<String> result = new ArrayList<String>();
        try {
            Statement stat = connection.createStatement();
            ResultSet rs = stat.executeQuery("select * from leagues");
            while (rs.next()) {
                String league_name = rs.getString("name");
                String league_season = rs.getString("season");
                String league_teams = rs.getString("teams"); //separates by ','
                String league_association_representative = rs.getString("association-representative");

                String current = league_name + ";" + league_season + ";" + league_teams +";"+league_association_representative;
                result.add(current);
            }

            return result;

        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }

    }

    @Override
    public void save(League league) throws SQLException {

        String league_teams = "";
        for (Team var : league.teams)
        {
            league_teams += var.getTeamName() + ",";
        }

        String league_association_representative = "";
        for (AssociationRepresentative var : league.associationRepresentatives)
        {
            league_association_representative += var.getName() + ",";
        }

        String league_name = league.LeagueName;
        String league_season = String.join(",", league.seasons); //separates by ','

        String query = "insert into leagues values (?,?,?,?)";
        PreparedStatement myStmt = connection.prepareStatement(query);
        myStmt.setString(1, league_name);
        myStmt.setString(2, league_season);
        myStmt.setString(3, league_teams);
        myStmt.setString(4, league_association_representative);

        int res = myStmt.executeUpdate();

        System.out.println(res + " records inserted");
    }

    @Override
    //this function update a team's league (PARAMS[0]) from one league to another.
    public void update(League league, String[] params) throws SQLException {

        //AUser user details
        String tempoNAME = league.LeagueName;

        //create a query
        String query = "UPDATE leagues SET season = ? WHERE name = ?";

        //prepare the statement
        PreparedStatement myStmt = connection.prepareStatement(query);


        //set the arguments of the query
        myStmt.setString(1, params[0]);
        myStmt.setString(2, tempoNAME);

        int res = myStmt.executeUpdate();
        System.out.println(res + " records updated");

    }

    @Override
    public void delete(League league) {
        try {
            String tempoNAME = league.LeagueName;

            String query = "DELETE FROM leagues WHERE name = ?";
            PreparedStatement myStmt = connection.prepareStatement(query);
            myStmt.setString(1,tempoNAME);
            int res = myStmt.executeUpdate();

            System.out.println(res + " records deleted");

        } catch (java.sql.SQLException e) {
            System.out.println(e.toString());
        }


    }
}
