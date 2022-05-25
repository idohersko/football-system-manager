package DataLayer;

import java.sql.*;

public class DBConnector {

    //singelton - private constructor - just one connection allowed
    private static final DBConnector instance = new DBConnector();
    public static final String URL = "jdbc:sqlite:footballDB.db";
    public static final String USER = "root";
    public static final String PASS = "root";


    /**
     * @return instance of DBconector
     * private constructor to avoid client applications to use constructor
     */
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
            Connection conn = DriverManager.getConnection(URL,USER,PASS);
            return conn;
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

    /**
     * @param conn connection
     * @return boolean if success
     * test connection to the database
     */

    private static boolean testConnection( Connection conn){
        try {
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("select * from Teams");
            while (rs.next()) {
                String team_name = rs.getString("name");
            }
            conn.close();

        } catch (SQLException ex) {
            return false;
        }


        return true;
    }


}
