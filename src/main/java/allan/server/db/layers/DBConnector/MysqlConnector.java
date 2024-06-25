package allan.server.db.layers.DBConnector;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlConnector {

    private Connection conn = null;
    private String server = "localhost:3306";
    private String db = "carodb";
    private String user = "root";
    private String pass = "543609072005";

    public MysqlConnector() {
//        if (checkDriver()) {
            setupConnection();
//        }
    }

    public void logIn(String userName, String pass) {
        this.user = userName;
        this.pass = pass;
        setupConnection();
    }

//    private boolean checkDriver() {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver"); // Updated driver class
//            return true;
//        } catch (ClassNotFoundException e) {
//            System.err.println("Cannot find MySQL driver!");
//            e.printStackTrace();
//            return false;
//        }
//    }

    private boolean setupConnection() {
        try {
            String url = "jdbc:mysql://" + server + "/" + db + "?useUnicode=true&characterEncoding=UTF-8";
            conn = DriverManager.getConnection(url, user, pass);
            return true;
        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
            return false;
        }
    }

    public ResultSet sqlQry(PreparedStatement stm) {
        if (checkConnection()) {
            try {
                return stm.executeQuery();
            } catch (SQLException e) {
                System.err.println("SQL query execution error: " + stm.toString() + ", " + e.getMessage());
            }
        }
        return null;
    }

    public boolean sqlUpdate(PreparedStatement stm) {
        if (checkConnection()) {
            try {
                stm.executeUpdate();
                return true;
            } catch (SQLException e) {
                System.err.println("SQL update execution error: " + stm.toString() + ", " + e.getMessage());
            }
        }
        return false;
    }

    private boolean checkConnection() {
        return conn != null;
    }

    public boolean closeConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
            return true;
        } catch (SQLException e) {
            System.err.println("Cannot close connection to " + db);
            return false;
        }
    }

    public Connection getConnection() {
        return conn;
    }
}
