package classes;

import util.Tools;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class MySQL {
    private static Connection wordConn = null;
    private static Statement wordStat = null;
    private static PreparedStatement wordPreparedStat = null;
    private static ResultSet rs;
    private static String query;
    private static String word;

    public static void makeJDBCConnection() {

        try {
            wordConn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "cl14m5");
            wordStat =  wordConn.createStatement();

            query = "CREATE DATABASE IF NOT EXISTS hanged;";

            wordStat.executeUpdate(query);

            query = "USE hanged";
            wordStat.executeUpdate(query);

            query = "CREATE TABLE IF NOT EXISTS words ("
                    + "id INT AUTO_INCREMENT,"
                    + " word VARCHAR(30),"
                    + " PRIMARY KEY (id));";

            wordStat.executeUpdate(query);

            query = "SELECT count(word) from words";

            rs = wordStat.executeQuery(query);

            if(rs.getRow() == 0){
                for(String w : Tools.fWords()){
                    addWordDataToDB(w);
                }
            }

            query = "CREATE TABLE IF NOT EXISTS winners ("
                    + "id INT AUTO_INCREMENT,"
                    + " name VARCHAR(30),"
                    + " points INT,"
                    + " day DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ,"
                    + " PRIMARY KEY (id));";

            wordStat.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void closeJDBCConnection() {
        try {
            wordStat.close();
            wordConn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void addWordDataToDB(String word) {

        try {
            query = "INSERT  INTO  words  (word) VALUES  (?);";
            wordPreparedStat = wordConn.prepareStatement(query);

            wordPreparedStat.setString(1, word);

            // execute insert SQL statement
            wordPreparedStat.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addWinnerDataToDB(Player w) {

        try {
            query = "INSERT  INTO  winners  (name,points,day) VALUES  (?,?,?);";
            wordPreparedStat = wordConn.prepareStatement(query);

            wordPreparedStat.setString(1, w.getName());
            wordPreparedStat.setInt(2, w.getPoints());
            wordPreparedStat.setObject(3, w.getDay());

            // execute insert SQL statement
            wordPreparedStat.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getRandomWordFromDB (){
        try {
            query = "SELECT word FROM words ORDER BY RAND() LIMIT 1;"; // Al ser una tabla con pocos registros uso ORDER BY RAND() LiMIT 1 para seleccionar un reg. al azar

            rs = wordStat.executeQuery(query);
            if(rs.next()){
                word = rs.getString("word");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return word;
    }

}
