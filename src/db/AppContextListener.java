package db;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppContextListener implements ServletContextListener {

	@Override
    public void contextInitialized(ServletContextEvent arg0) {
    	SetupDao sdao = new SetupDao();
    	sdao.dropDatabase();
    	sdao.createSchema();
    }
	@Override
    public void contextDestroyed(ServletContextEvent arg0) {
    	
    }	
}
