package db;

import javax.servlet.ServletContextEvent;

public class ServletContextListener implements javax.servlet.ServletContextListener {

	db.SetupDao sdao = new db.SetupDao();
	
    public void contextInitialized(ServletContextEvent arg0) {
    	sdao.dropDatabase();
    	sdao.createSchema();
    	sdao.createTestdata();
    }

    public void contextDestroyed(ServletContextEvent arg0) {
    	
    }	
}
