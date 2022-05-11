package DataLayer;

import DomainLayer.Users.*;

import java.sql.*;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class UsersDB implements DB<AUser> {
    private static final UsersDB instance = new UsersDB();

    //private constructor to avoid client applications to use constructor
    public static UsersDB getInstance(){

        return instance;
    }

    private UsersDB() {
        DBConnector dbc = DBConnector.getInstance();
        // users.add(new User("John", "password123", "referee", "0"));
        //users.add(new User("Susan", "pass12", "player", "1"));
    }

    @Override
    // todo - (ido) - to get the user, what do i need to give ? only username  ? id ? all the credentials ?
    public Optional<AUser> get(long id) {
//        // Register Driver Class
//        Class.forName("org.apache.derby.jdbc.ClientDriver");
        // Connection to your database
        Connection connection = DBConnector.getConnection();
        // Query which needs parameters
        try {

            String query = "Select * from students where userName = ? and password = ? and userType = ? and userStatus = ?";

            // Prepare Statement
            PreparedStatement myStmt = connection.prepareStatement(query);

            //parameters todo - bring them from domain.user
            String tempoNAME = "ido";
            String tempoPASS = "ido";
            String tempoTYPE = "Referee";
            int tempoACTIVATION = 1;

            // Set Parameters
            myStmt.setString(1, tempoNAME);
            myStmt.setString(2, tempoPASS);
            myStmt.setString(3, tempoTYPE);
            myStmt.setInt(4,tempoACTIVATION);

            // Execute SQL query
            ResultSet rs = myStmt.executeQuery();

            // Display function to show the Resultset
            System.out.println("username      password      type      status");
            while (rs.next()) {
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String userType = rs.getString("userType");
                int userStatus = rs.getInt("statusActivation");
                // todo - (ido) - add the info to return object

                if (userType.toLowerCase(Locale.ROOT).equals("referee") ){
                    return Optional.of(new Referee()); //todo - (ido) - check that this return a referee
                }
                if (userType.toLowerCase(Locale.ROOT).equals("coach") ){
                    return Optional.of(new Coach()); //todo - (ido) - check that this return a referee
                }
                if (userType.toLowerCase(Locale.ROOT).equals("player") ){
                    return Optional.of(new Player()); //todo - (ido) - check that this return a referee
                }
                if (userType.toLowerCase(Locale.ROOT).equals("systemadmin") ){
                    return Optional.of(new SystemAdmin()); //todo - (ido) - check that this return a referee
                }
                if (userType.toLowerCase(Locale.ROOT).equals("fan") ){
                    return Optional.of(new Fan()); //todo - (ido) - check that this return a referee
                }
//                if (userType.toLowerCase(Locale.ROOT).equals("guest") ){
//                    return Optional.of(new Guest()); //todo - (ido) - check that this return a referee
//                }
                if (userType.toLowerCase(Locale.ROOT).equals("teamowner") ){
                    return Optional.of(new TeamOwner()); //todo - (ido) - check that this return a referee
                }
                if (userType.toLowerCase(Locale.ROOT).equals("teammanager") ){
                    return Optional.of(new TeamManager()); //todo - (ido) - check that this return a referee
                }
                String p = userName + " " + password + " " + userType + " " + userStatus;
                System.out.println(p);
            }

            // todo - (ido) - !!!!!!!!!!!!!!!! maybe all the above should not be in the datalayer  ??????????

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Close the connection
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //return null
        return Optional.empty();
    }

    @Override
    public List<AUser> getAll() {
        try {
            Connection connection = DBConnector.getConnection();
            Statement stat = connection.createStatement();
            ResultSet rs = stat.executeQuery("select * from users");
            while (rs.next()) {
                String userName = rs.getString("name");
                String password = rs.getString("password");
                String userType = rs.getString("type");
                int userStatus = rs.getInt("status");
                String p = userName + " " + password + " " + userType + " " + userStatus;
                System.out.println(p);
            }
            connection.close();

        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
        return null;
    }

    @Override
    public void save(AUser user)  {
        try {

            Connection connection = DBConnector.getConnection();
            String tempoNAME = "user.getname();";
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
