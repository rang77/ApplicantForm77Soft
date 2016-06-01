package listener;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import db.LeaveRequestDAO;
import db.LoginDAO;
import db.ResourceDAO;
import db.SalesforceDAO;
import utility.ContextKeys;

/**
 * Application Lifecycle Listener implementation class InitializerServletContextListener
 *
 */
@WebListener
public class InitializerServletContextListener implements ServletContextListener {
	
    public InitializerServletContextListener() {
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  {
    	ServletContext context = sce.getServletContext();
    	
    	Properties prop = new Properties();
    	try {
    		System.out.println("Loading connection properties..");
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("connection.properties"));
			
			SalesforceDAO.setClientID(prop.getProperty("clientId"));
			SalesforceDAO.setClientSecret(prop.getProperty("clientSecret"));
			SalesforceDAO.setDomain(prop.getProperty("domain"));
			SalesforceDAO.setUsername(prop.getProperty("username"));
			SalesforceDAO.setPassword(prop.getProperty("password"));
			SalesforceDAO.setSecurityToken(prop.getProperty("securityToken"));
			
			System.out.println("Initializing DAOs....");
			context.setAttribute(ContextKeys.LEAVE_REQUEST_DAO, new LeaveRequestDAO());
			context.setAttribute(ContextKeys.RESOURCE_DAO, new ResourceDAO());
			context.setAttribute(ContextKeys.LOGIN_DAO, new LoginDAO());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
}
