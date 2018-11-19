package fr.iat.facturation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    /**
     * @url : https://www.programcreek.com/2009/07/put-database-connection-to-servletcontextlistener/
     */

    private Connection conn = null;

    public Database(String url, String user_name, String password) {
        try {
            Class.forName("org.postgresql.Driver");

            this.conn = DriverManager.getConnection(url, user_name, password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.conn;
    }

//    public ResultSet runSql(String sql) throws SQLException {
//        Statement sta = conn.createStatement();
//        return sta.executeQuery(sql);
//    }
}
