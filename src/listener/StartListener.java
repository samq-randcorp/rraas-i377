package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import db.SetupDao;

public class StartListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		SetupDao sd = new SetupDao();
	     sd.createSchema();
	     sd.addTestdata();
	}

}
