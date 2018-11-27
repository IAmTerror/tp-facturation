package fr.iat.facturation;

import fr.iat.facturation.model.Client;
import fr.iat.facturation.service.Database;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Update extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        Database db = (Database) getServletContext().getAttribute("db");
//        Connection conn = db.getConnection();

        String id = httpServletRequest.getParameter("id");
        String nom = httpServletRequest.getParameter("nom");
        String prenom = httpServletRequest.getParameter("pnom");
        String loc = httpServletRequest.getParameter("loc");
        String pays = httpServletRequest.getParameter("pays");

        try {

//            Statement statement = conn.createStatement();
            // UPDATE --------------------------------------------------------------------------------------------------
//            String updateQuery = "update clients set clt_nom='" + nom + "', clt_pnom='" + prenom + "', clt_loc='" + loc + "', clt_pays='" + pays + "'  where clt_num='" + id + "'";
//            statement.executeUpdate(updateQuery);
            PreparedStatement statement = db.updateClient(id, nom, prenom, loc, pays);
            statement.executeUpdate();

            // redirection
            httpServletResponse.sendRedirect("/clients");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        Database db = (Database) getServletContext().getAttribute("db");
//        Connection conn = db.getConnection();
        Template update = (Template) getServletContext().getAttribute("update");

        String id = httpServletRequest.getParameter("id");

        try {

//            Statement statement = conn.createStatement();

            // SELECT --------------------------------------------------------------------------------------------------
//            String query = "SELECT clt_num, clt_nom, clt_pnom, clt_loc, clt_pays FROM clients WHERE clt_num = '" + id + "'";
//            ResultSet rs = statement.executeQuery(query);
            PreparedStatement statement = db.selectAllFromClientsByNum(id);
            ResultSet rs = statement.executeQuery();
            Client client = null;
            while (rs.next()) {
                client = new Client(rs.getString("clt_num"),
                        rs.getString("clt_nom"),
                        rs.getString("clt_pnom"),
                        rs.getString("clt_loc"),
                        rs.getString("clt_pays"));
            }

            Map<String, Object> datas = new HashMap<>();
            datas.put("client", client);
            update.process(datas, httpServletResponse.getWriter());

//            // pour les besoins de la vue
//            httpServletRequest.setAttribute("client", client);
//            // délegation à la vue
//            String jspview = "update.jsp";
//            getServletConfig().getServletContext()
//                    .getRequestDispatcher("/WEB-INF/jsp/" + jspview)
//                    .forward(httpServletRequest, httpServletResponse);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
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
