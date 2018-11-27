package fr.iat.facturation.service;


import freemarker.template.Configuration;
import freemarker.template.Template;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;

public class ServletListener implements ServletContextListener {

    /**
     * @url : https://www.programcreek.com/2009/07/put-database-connection-to-servletcontextlistener/
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */

    private Template listeClients;
    private Template create;
    private Template delete;
    private Template update;

    public void contextInitialized(ServletContextEvent event) {

        ServletContext sc = event.getServletContext();

        String user = sc.getInitParameter("user");
        String password = sc.getInitParameter("password");
        String nameBDD = sc.getInitParameter("nameBDD");
        String host = sc.getInitParameter("host");
        String port = sc.getInitParameter("port");
        Database db = new Database("jdbc:postgresql://" + host + ":" + port + "/" + nameBDD, user, password);
        sc.setAttribute("db", db);

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);
        cfg.setServletContextForTemplateLoading(sc,"/WEB-INF/templates");
        cfg.setDefaultEncoding("UTF8");
        try {
            listeClients = cfg.getTemplate("clients.ftl");
            sc.setAttribute("listeClients", listeClients);
            create = cfg.getTemplate("create.ftl");
            sc.setAttribute("create", create);
            delete = cfg.getTemplate("delete.ftl");
            sc.setAttribute("delete", delete);
            update = cfg.getTemplate("update.ftl");
            sc.setAttribute("update", update);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */

    public void contextDestroyed(ServletContextEvent arg0) {
    }
}
