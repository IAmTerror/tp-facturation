package fr.iat.facturation.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
            System.out.println(("Pas de Driver SQL"));
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Pas de connexion à la base");
        }
    }

    public Connection getConnection() {
        return this.conn;
    }

    public PreparedStatement selectAllFromClients() throws SQLException {
        String query = "SELECT clt_num, clt_nom, clt_pnom, clt_loc, clt_pays FROM clients";
        PreparedStatement statement = conn.prepareStatement(query);
        return statement;
    }

    public PreparedStatement selectAllFromClientsByNum(String num) throws SQLException {
        String query = "SELECT clt_num, clt_nom, clt_pnom, clt_loc, clt_pays FROM clients WHERE clt_num = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString (1, num);
        return statement;
    }

    public PreparedStatement createClient(String num, String nom, String pnom, String loc, String pays) throws SQLException {
        String query = "INSERT INTO clients (clt_num, clt_nom, clt_pnom, clt_loc, clt_pays) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString (1, num);
        statement.setString (2, nom);
        statement.setString (3, pnom);
        statement.setString (4, loc);
        statement.setString (5, pays);
        return statement;
    }

    public PreparedStatement updateClient(String num, String nom, String pnom, String loc, String pays) throws SQLException {
        String query = "update clients set clt_nom = ?, clt_pnom = ?, clt_loc = ? , clt_pays = ?  where clt_num = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString (1, nom);
        statement.setString (2, pnom);
        statement.setString (3, loc);
        statement.setString (4, pays);
        statement.setString (5, num);
        return statement;
    }

    public PreparedStatement deleteClient(String num) throws SQLException {
        String query = "DELETE from clients where clt_num = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString (1, num);
        return statement;
    }
}
