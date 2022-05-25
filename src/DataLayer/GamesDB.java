package DataLayer;

import DomainLayer.Enums;
import DomainLayer.Games.Game;
import DomainLayer.Games.League;
import DomainLayer.Games.Team;
import DomainLayer.Users.Referee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GamesDB implements DB<Game> {
    private static final GamesDB instance = new GamesDB();
    private Connection connection;

    //private constructor to avoid client applications to use constructor
    public static GamesDB getInstance(){
        return instance;
    }

    /**
     * private constructor to avoid client applications to use constructor
     */
    private GamesDB() {
        this.connection = DBConnector.getConnection();
    }
    @Override
    public String get(String name) {

        try
        {
            String query = "Select * from games where name = ?";

            // Prepare Statement
            PreparedStatement myStmt = connection.prepareStatement(query);

            // Set Parameters
            myStmt.setString(1, name);

            // Execute SQL query
            ResultSet rs = myStmt.executeQuery();

            // Display function to show the Resultset
            String answer = "";
            while (rs.next()) {
                String th = rs.getString("teamHome");
                String tg = rs.getString("teamGuest");
                String dat = rs.getString("date");
                String s = rs.getString("season");
                String fi = rs.getString("field");
                String sc = rs.getString("score");
                String ev = rs.getString("events");
                String ref = rs.getString("referees");

                answer = th + ";" + tg + ";" + dat+ ";" + s + ";" + fi+ ";" + sc + ";" + ev+ ";" + ref;
            }
            return answer;

        }
        catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }

    }

    /**
     * @return an array of strings of all the games fivides by a ; delimeter
     */
    @Override
    public ArrayList<String> getAll() {
        ArrayList<String> result = new ArrayList<String>();
        try {
            Statement stat = connection.createStatement();
            ResultSet rs = stat.executeQuery("select * from games");
            while (rs.next()) {
                String th = rs.getString("teamHome");
                String tg = rs.getString("teamGuest");
                String dat = rs.getString("date");
                String s = rs.getString("season");
                String fi = rs.getString("field");
                String sc = rs.getString("score");
                String ev = rs.getString("events");
                String ref = rs.getString("referees");

                String answer = th + ";" + tg + ";" + dat+ ";" + s + ";" + fi+ ";" + sc + ";" + ev+ ";" + ref;
                result.add(answer);
            }

            return result;

        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }

    }

    /**
     * @param gm game
     * @throws SQLException return an exception if the DB didnt connect well
     */
    @Override
    public void save(Game gm) throws SQLException {

        String events = "";  //separate by ","
        for (Enums.EventType var : gm.events)
        {
            events += var.toString() + ",";
        }

        String th = gm.team_home;
        String tg = gm.team_guest;
        String dat = gm.date;
        String s = gm.season;
        String fi = gm.field;
        String sc = Integer.toString(gm.score);

        String ref = String.join( ",",gm.referees); //separate by ","

        String query = "insert into games values (?,?,?,?,?,?,?,?)";
        PreparedStatement myStmt = connection.prepareStatement(query);
        myStmt.setString(1, th);
        myStmt.setString(2, tg);
        myStmt.setString(3, dat);
        myStmt.setString(4, s);
        myStmt.setString(5, fi);
        myStmt.setString(6, sc);
        myStmt.setString(7, events);
        myStmt.setString(8, ref);
        int res = myStmt.executeUpdate();
    }

    /**
     * @param gm game
     * @param params an array of strings, update the score of the game at PARAMS[0]
     * @throws SQLException  return an exception if the DB didnt connect well
     */
    @Override
    public void update(Game gm, String[] params) throws SQLException {

        //AUser user details
        String th = gm.team_home;
        String tg = gm.team_guest;
        String dat = gm.date;
        String s = gm.season;

        //create a query
        String query = "UPDATE games SET score=? WHERE teamHome = ? and teamGuest = ? and date = ? and season = ?";

        //prepare the statement
        PreparedStatement myStmt = connection.prepareStatement(query);


        //set the arguments of the query
        myStmt.setString(1, params[0]);
        myStmt.setString(2, th);
        myStmt.setString(3, tg);
        myStmt.setString(4, dat);
        myStmt.setString(5, s);

        int res = myStmt.executeUpdate();

    }

    @Override
    public void delete(Game gm) {
        try {
            String th = gm.team_home;
            String tg = gm.team_guest;
            String dat = gm.date;
            String s = gm.season;

            String query = "DELETE FROM games WHERE teamHome = ? and teamGuest = ? and date = ?";
            PreparedStatement myStmt = connection.prepareStatement(query);
            myStmt.setString(1, th);
            myStmt.setString(2, tg);
            myStmt.setString(3, dat);
            int res = myStmt.executeUpdate();

        } catch (java.sql.SQLException e) {
            System.out.println(e.toString());
        }


    }
}
