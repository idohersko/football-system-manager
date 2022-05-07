package DataLayer;

import java.sql.*;

public class DBConnector {

    //singelton - private constructor - just one connection allowed
    private static final DBConnector instance = new DBConnector();
    public static final String URL = "jdbc:mysql://localhost:3306/";
    public static final String USER = "root";
    public static final String PASS = "root";



    //private constructor to avoid client applications to use constructor
    public static DBConnector getInstance(){
        return instance;
    }

    private DBConnector() {

    }
    /**
     * Get a connection to database
     *
     * @return Connection object
     */
    public static Connection getConnection() {
        try {
            //DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //return DriverManager.getConnection(URL, USER, PASS);
            Connection conn = DriverManager.getConnection(URL,USER,PASS);
            return conn;
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

    // test connection
    private static void testConnection( Connection conn){
        try {
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("select * from Teams");
            while (rs.next()) {
                String team_name = rs.getString("name");
                System.out.println(team_name);
            }
            conn.close();

        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }


}