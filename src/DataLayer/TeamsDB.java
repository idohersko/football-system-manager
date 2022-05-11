package DataLayer;

import DomainLayer.Games.Team;
import DomainLayer.Users.Referee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TeamsDB implements DB<Team>{
    private static final TeamsDB instance = new TeamsDB();
    private Connection connection;

    //private constructor to avoid client applications to use constructor
    public static TeamsDB getInstance(){
        return instance;
    }

    //private constructor
    private TeamsDB() {
        this.connection = DBConnector.getConnection();
    }
    @Override
    public String get(String name) {

        try
        {
            String query = "Select * from teams where name = ?";

            // Prepare Statement
            PreparedStatement myStmt = connection.prepareStatement(query);

            // Set Parameters
            myStmt.setString(1, name);

            // Execute SQL query
            ResultSet rs = myStmt.executeQuery();

            // Display function to show the Resultset
            String answer = "";
            while (rs.next()) {
                String teamName = rs.getString("name");
                String league = rs.getString("league");
                String teamOwner = rs.getString("teamOwner");

                answer = teamName + ";" + league + ";" + teamOwner;
            }
            return answer;

        }
        catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }

//        // Close the connection
//        try {
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        //todo ----- DO WE NEED TO CLOSE THE CONNECTION IN EACH FUNCTION ?

    }

    @Override
    public ArrayList<String> getAll() {
        ArrayList<String> result = new ArrayList<String>();
        try {
            Statement stat = connection.createStatement();
            ResultSet rs = stat.executeQuery("select * from teams");
            while (rs.next()) {
                String teamName = rs.getString("name");
                String league = rs.getString("league");
                String teamOwner = rs.getString("teamOwner");

                String current = teamName + ";" + league + ";" + teamOwner;
                result.add(current);
            }

            return result;

        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }

    }

    @Override
    public void save(Team team) throws SQLException {

        String teamNAME = team.getTeamName();
        String teamLEAGUE = team.getLeague().LeagueName;
        String teamTEAMOWNER = team.getTeamOwner();

        String query = "insert into teams values (?,?,?)";
        PreparedStatement myStmt = connection.prepareStatement(query);
        myStmt.setString(1, teamNAME);
        myStmt.setString(2, teamLEAGUE);
        myStmt.setString(3, teamTEAMOWNER);

        int res = myStmt.executeUpdate();

        System.out.println(res + " records inserted");
    }

    @Override
    //this function update a team's league (PARAMS[0]) from one league to another.
    public void update(Team team, String[] params) throws SQLException {

        //AUser user details
        String tempoNAME = team.getTeamName();

        //create a query
        String query = "UPDATE teams SET league=? WHERE name = ?";

        //prepare the statement
        PreparedStatement myStmt = connection.prepareStatement(query);


        //set the arguments of the query
        myStmt.setString(1, params[0]);
        myStmt.setString(2, tempoNAME);

        int res = myStmt.executeUpdate();
        System.out.println(res + " records updated");

    }

    @Override
    public void delete(Team team) {
        try {
            String tempoNAME = team.getTeamName();
            String query = "DELETE FROM teams WHERE name = ?";
            PreparedStatement myStmt = connection.prepareStatement(query);
            myStmt.setString(1,tempoNAME);
            int res = myStmt.executeUpdate();

            System.out.println(res + " records deleted");

        } catch (java.sql.SQLException e) {
            System.out.println(e.toString());
        }

    }
}
