package DataLayer;

import DomainLayer.Users.AUser;
import DomainLayer.Users.Referee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RefereesDB implements DB<Referee> {
    private static final RefereesDB instance = new RefereesDB();
    private Connection connection;

    //private constructor to avoid client applications to use constructor
    public static RefereesDB getInstance(){
        return instance;
    }

    /**
     * private constructor to avoid client applications to use constructor
     */
    private RefereesDB() {
        this.connection = DBConnector.getConnection();
    }

    /**
     * @param name string of referee's name
     * @return a string of the referee with ; as parameter delimeter
     */
    @Override
    public String get(String name) {

        try
        {
            String query = "Select * from referees where name = ?";

            // Prepare Statement
            PreparedStatement myStmt = connection.prepareStatement(query);

            // Set Parameters
            myStmt.setString(1, name);

            // Execute SQL query
            ResultSet rs = myStmt.executeQuery();

            // Display function to show the Resultset
            String answer = "";
            while (rs.next()) {
                String userName = rs.getString("name");
                String password = rs.getString("password");
                String userType = rs.getString("type");
                String userStatus = rs.getString("status");
                String level = rs.getString("level");
                answer = userName + ";" + password + ";" + userType + ";" + userStatus+";"+level;
            }
            return answer;

        }
        catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }

    }

    /**
     * @return all the referees  with the ; delimeter
     */
    @Override
    public ArrayList<String> getAll() {
        ArrayList<String> result = new ArrayList<String>();
        try {
            Statement stat = connection.createStatement();
            ResultSet rs = stat.executeQuery("select * from referees");
            while (rs.next()) {
                String userName = rs.getString("name");
                String password = rs.getString("password");
                String userType = rs.getString("type");
                String userStatus = rs.getString("status");
                String level = rs.getString("level");
                String current = userName + ";" + password + ";" + userType + ";" + userStatus+";"+level;
                result.add(current);
            }

            return result;

        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }

    }

    /**
     * @param referee a referee i wish to save in the DB
     * @throws SQLException excpetion  with the connection
     */
    @Override
    public void save(Referee referee) throws SQLException {

        String tempoNAME = referee.getName();
        String tempoPASS = referee.getPassword();
        String tempoTYPE = referee.getUserType().toString();
        String tempoACTIVATION = referee.getStatus().toString();
        String tempoLEVEL = referee.getRefereeLevel().toString();
        String query = "insert into referees values (?,?,?,?,?)";
        PreparedStatement myStmt = connection.prepareStatement(query);
        myStmt.setString(1, tempoNAME);
        myStmt.setString(2, tempoPASS);
        myStmt.setString(3, tempoTYPE);
        myStmt.setString(4, tempoACTIVATION);
        myStmt.setString(5, tempoLEVEL);
        int res = myStmt.executeUpdate();

    }

    /**
     * @param referee a referee i want to change from inactive to active
     * @param params array of strings, unused here in the function
     * @throws SQLException
     * this function update a referee from inactive to active
     */
    @Override

    public void update(Referee referee, String[] params) throws SQLException {

        //AUser user details
        String tempoNAME = referee.getName();

        //create a query
        String query = "UPDATE referee SET status=? WHERE name = ?";

        //prepare the statement
        PreparedStatement myStmt = connection.prepareStatement(query);


        //set the arguments of the query
        myStmt.setString(1, "ACTIVE");
        myStmt.setString(2, tempoNAME);

        int res = myStmt.executeUpdate();

    }

    /**
     * @param referee a referee i wish to delete from DB
     */
    @Override
    public void delete(Referee referee) {
        try {
            String tempoNAME = referee.getName();
            String tempoPASS = referee.getPassword();
            String query = "DELETE FROM referees WHERE name = ? and password = ?";
            PreparedStatement myStmt = connection.prepareStatement(query);
            myStmt.setString(1,tempoNAME);
            myStmt.setString(2,tempoPASS);
            int res = myStmt.executeUpdate();


        } catch (java.sql.SQLException e) {
            System.out.println(e.toString());
        }

    }
}
