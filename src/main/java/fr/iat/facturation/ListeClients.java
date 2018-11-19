package fr.iat.facturation;

import fr.iat.facturation.model.Client;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ListeClients extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        Database db = (Database) getServletContext().getAttribute("db");
        Connection conn = db.getConnection();

        try {

            // SELECT --------------------------------------------------------------------------------------------------
            Statement statement = conn.createStatement();
            String query = "SELECT clt_num, clt_nom, clt_pnom, clt_loc, clt_pays FROM clients";
            ResultSet res = statement.executeQuery(query);
            List<Client> clients = new ArrayList<Client>();
            while (res.next()) {
                clients.add(new Client(res.getString("clt_num"),
                        res.getString("clt_nom"),
                        res.getString("clt_pnom"),
                        res.getString("clt_loc"),
                        res.getString("clt_pays")));
            }

            // pour les besoins de la vue
            httpServletRequest.setAttribute("clients", clients);
            // délégation à la vue
            String laVue = "clients.jsp";
            getServletConfig().getServletContext()
                    .getRequestDispatcher("/WEB-INF/jsp/" + laVue).forward(httpServletRequest, httpServletResponse);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    @Override
//    public void init() throws ServletException {
//        super.init();
//        try {
//
//            String user = getServletContext().getInitParameter("user");
//            String password = getServletContext().getInitParameter("password");
//            String nameBDD = getServletContext().getInitParameter("nameBDD");
//            String host = getServletContext().getInitParameter("host");
//            String port = getServletContext().getInitParameter("port");
//
//            Class.forName("org.postgresql.Driver");
//            Properties props = new Properties();
//            props.setProperty("user", user);
//            props.setProperty("password", password);
//            conn = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + nameBDD, props);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//            throw new ServletException("Pas de Driver SQL");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new ServletException("Pas de connexion à la base");
//        }
//
//    }
}
