package DataLayer;

import DomainLayer.Users.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class UsersDB implements DB<AUser> {
    private static final UsersDB instance = new UsersDB();
    private Connection connection;

    //private constructor to avoid client applications to use constructor
    public static UsersDB getInstance(){
        return instance;
    }

    //private constructor
    private UsersDB() {
        this.connection = DBConnector.getConnection();
    }

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
                int userStatus = rs.getInt("status");
                //// todo - (ido) - add the info to return object
                answer = userName + ";" + password + ";" + userType + ";" + userStatus;
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
            ResultSet rs = stat.executeQuery("select * from users");
            while (rs.next()) {
                String userName = rs.getString("name");
                String password = rs.getString("password");
                String userType = rs.getString("type");
                int userStatus = rs.getInt("status");

                String current = userName + ";" + password + ";" + userType + ";" + userStatus;
                result.add(current);
            }
            return result;

        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }

    }

    @Override
    public void save(AUser user)  {
        try {
            String tempoNAME = "";
            String tempoPASS = "getpassword();";
            String tempoTYPE = "Referee";
            int tempoACTIVATION = 1;
            String query = "insert into users values (?,?,?,?)";
            PreparedStatement myStmt = connection.prepareStatement(query);
            myStmt.setString(1,tempoNAME);
            myStmt.setString(2,tempoPASS);
            myStmt.setString(3,tempoTYPE);
            myStmt.setInt(4,tempoACTIVATION);
            int res = myStmt.executeUpdate();

            System.out.println(res + " records inserted");
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

    }


    @Override
    public void update(AUser user, String[] params) {

    }

    @Override
    // todo - (ido) - do we search the user with the name and then delete?
    public void delete(AUser user) {
        try {
            Connection connection = DBConnector.getConnection();
            String tempoNAME = "ido";
            String tempoPASS = "ido";
            String query = "DELETE FROM users WHERE userName=? and password=?";
            PreparedStatement myStmt = connection.prepareStatement(query);
            myStmt.setString(1,tempoNAME);
            myStmt.setString(2,tempoPASS);
            int res = myStmt.executeUpdate();

            System.out.println(res + " records deleted");
            connection.close();
        } catch (java.sql.SQLException e) {
            System.out.println(e.toString());
        }

    }
}
