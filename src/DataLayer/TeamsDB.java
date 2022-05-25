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

    /**
     * private constructor to avoid client applications to use constructor
     */
    private TeamsDB() {
        this.connection = DBConnector.getConnection();
    }

    /**
     * @param name string of a team that i wish to retrieve from the DB
     * @return a string of the team, its parameters are delimited by ;
     */
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

    }

    /**
     * @return an array of strings, the delimeter is ; between each league
     */
    @Override
    public ArrayList<String> getAll() {
        ArrayList<String> result = new ArrayList<String>();
        try {
            Statement stat = connection.createStatement();
            ResultSet rs = stat.executeQuery("select * from teams");
            while (rs.next()) {
                String teamName = rs.getString("teamName");
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

    /**
     * @param team save the team in the DB
     * @throws SQLException exception if something wrong happends during the connection
     */
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
    }

    /**
     * @param team a team i wish to update
     * @param params array of string
     * @throws SQLException error with the connection
     * this function update a team's league (PARAMS[0]) from one league to another.
     */
    @Override
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

    }

    /**
     * @param t a team i wish to delete
     */
    @Override
    public void delete(Team t) {

        try {
            String tempoNAME = t.getTeamName();

            String query = "DELETE FROM teams WHERE name = ?";
            PreparedStatement myStmt = connection.prepareStatement(query);
            myStmt.setString(1,tempoNAME);
            int res = myStmt.executeUpdate();


        } catch (java.sql.SQLException e) {
            System.out.println(e.toString());
        }



    }
}
