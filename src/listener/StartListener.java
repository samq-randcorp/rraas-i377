package listener;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import db.SetupDao;

public class StartListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		String home =System.getProperty("user.home");
		String db = "/data/rrass/db.script";
		Boolean fileExsist = new File(home+db).exists();
		if(fileExsist==false){
			SetupDao sd = new SetupDao();
		     sd.createSchema();
		     sd.addTestdata();
		}
		

	}

}
