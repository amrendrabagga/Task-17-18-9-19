package com.wp.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.Session;

import com.wp.util.Util;

/**
 * Application Lifecycle Listener implementation class HibernateSessionListener
 *
 */
public class HibernateSessionListener implements ServletContextListener {

   private Session session;
    public HibernateSessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         session = Util.getSF().openSession();
         ServletContext context = arg0.getServletContext();
         context.setAttribute("hSession", session);
    }
	
}
