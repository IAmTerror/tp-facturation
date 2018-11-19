package fr.iat.facturation.service;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletListener implements ServletContextListener {

    /**
     * @url : https://www.programcreek.com/2009/07/put-database-connection-to-servletcontextlistener/
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event) {

        ServletContext sc = event.getServletContext();

        String user = sc.getInitParameter("user");
        String password = sc.getInitParameter("password");
        String nameBDD = sc.getInitParameter("nameBDD");
        String host = sc.getInitParameter("host");
        String port = sc.getInitParameter("port");
        Database db = new Database("jdbc:postgresql://" + host + ":" + port + "/" + nameBDD, user, password);
        //System.out.println("in the listener!!");
        sc.setAttribute("db", db);

    }

    /**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
    }
}
