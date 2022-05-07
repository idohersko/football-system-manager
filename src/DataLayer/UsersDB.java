package DataLayer;

//import DomainLayer.User;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class UsersDB implements DB<UsersDB> {
    private static final UsersDB instance = new UsersDB();
    DBConnector dbc = DBConnector.getInstance();
    //private constructor to avoid client applications to use constructor
    public static UsersDB getInstance(){
        return instance;
    }

    private UsersDB() {
        // users.add(new User("John", "john@domain.com"));
        //users.add(new User("Susan", "susan@domain.com"));
    }

    @Override
    public Optional<UsersDB> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<UsersDB> getAll() {
        try {
            Connection connection = DBConnector.getConnection();
            Statement stat = connection.createStatement();
            ResultSet rs = stat.executeQuery("select * from users");
            while (rs.next()) {
                int id = rs.getInt("id");
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String userType = rs.getString("userType");
                String p = id + " " + userName + " " + password + " " + userType;
                System.out.println(p);
            }
            connection.close();

        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
        return null;
    }

    @Override
    // TODO: change that the function will receive a user from the domain
    public void save(UsersDB user)  {
        try {
            Connection connection = DBConnector.getConnection();
            Statement stmt = connection.createStatement();
            String tempoNAME = "ido";
            String tempoPASS = "ido";
            String tempoTYPE = "Referee";
            String query = "insert into users values (?,?,?)";
            PreparedStatement myStmt = connection.prepareStatement(query);
            myStmt.setString(1,tempoNAME);
            myStmt.setString(2,tempoPASS);
            myStmt.setString(3,tempoTYPE);
            int res = myStmt.executeUpdate();

            System.out.println(res + " records inserted");
            connection.close();
        } catch (java.sql.SQLException e) {
            System.out.println(e.toString());
        }

    }


    @Override
    public void update(UsersDB user, String[] params) {

    }

    @Override
    public void delete(UsersDB user) {

    }
}
