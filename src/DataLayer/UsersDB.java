package DataLayer;

import DomainLayer.Enums;
import DomainLayer.Users.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static java.lang.Integer.parseInt;

public class UsersDB implements DB<AUser> {
    private static final UsersDB instance = new UsersDB();
    private Connection connection;

    /**
     * private constructor to avoid client applications to use constructor
     */
    public static UsersDB getInstance(){
        return instance;
    }

    //private constructor
    private UsersDB() {
        this.connection = DBConnector.getConnection();
    }

    /**
     * @param name string of a user that i wish to retrieve from the DB
     * @return a string of the user, its parameters are delimited by ;
     */
    @Override
    public String get(String name) {

        try
        {
            String query = "Select * from users where name = ?";

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
                answer = userName + ";" + password + ";" + userType + ";" + userStatus;
            }
            return answer;

        }
        catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }

    }

    /**
     * @return an array of strings, the delimeter is ; between each user
     */
    @Override
    public ArrayList<String> getAll() {
        ArrayList<String> result = new ArrayList<String>();
        try {
            Statement stat = connection.createStatement();
            ResultSet rs = stat.executeQuery("select * from users");
            while (rs.next()) {
                String userName = rs.getString("name");
                String password = rs.getString("password");
                String userType = rs.getString("type");
                String userStatus = rs.getString("status");

                String current = userName + ";" + password + ";" + userType + ";" + userStatus;
                result.add(current);
            }
            return result;

        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }

    }

    /**
     * @param user a user i wish to save in DB
     * @throws SQLException error with the connection of the DB
     */
    @Override
    public void save(AUser user) throws SQLException {

        String tempoNAME = user.getName();
        String tempoPASS = user.getPassword();
        String tempoTYPE = user.getUserType().toString();
        String tempoACTIVATION = user.getStatus().toString();
        String query = "insert into users values (?,?,?,?)";
        PreparedStatement myStmt = connection.prepareStatement(query);
        myStmt.setString(1, tempoNAME);
        myStmt.setString(2, tempoPASS);
        myStmt.setString(3, tempoTYPE);
        myStmt.setString(4, tempoACTIVATION);
        int res = myStmt.executeUpdate();
    }

    /**
     * @param user a user i wish to update
     * @param params array of strings
     * @throws SQLException error in connection with DB
     * i take pass and username and check if pass is ok if good i update and send SUCCESS , but,  if pass fail or username does not exist return FAIL
     * this function update a user from inactive to active
     */
    @Override
    public void update(AUser user, String[] params) throws SQLException {

        //AUser user details
        String tempoNAME = user.getName();

        //create a query
        String query = "UPDATE users SET status=? WHERE name = ?";

        //prepare the statement
        PreparedStatement myStmt = connection.prepareStatement(query);


        //set the arguments of the query
        myStmt.setString(1, "ACTIVE");
        myStmt.setString(2, tempoNAME);

        int res = myStmt.executeUpdate();
    }

    /**
     * @param user a user i wish to delete
     */
    @Override
    public void delete(AUser user) {
        try {
            String tempoNAME = user.getName();
            String tempoPASS = user.getPassword();
            String query = "DELETE FROM users WHERE name = ? and password = ?";
            PreparedStatement myStmt = connection.prepareStatement(query);
            myStmt.setString(1,tempoNAME);
            myStmt.setString(2,tempoPASS);
            int res = myStmt.executeUpdate();

        } catch (java.sql.SQLException e) {
            System.out.println(e.toString());
        }

    }
}
