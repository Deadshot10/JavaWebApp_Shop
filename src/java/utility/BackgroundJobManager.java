package utility;

import java.io.File;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class BackgroundJobManager implements ServletContextListener {

    private ScheduledExecutorService scheduler;
    
    public class SomeDailyJob implements Runnable {
        @Override
        public void run() {
        	Log.log(getClass(), "start schelduled parsing file");
    	    try {
    	    	File file =  new File(ManagementSystem.getInstance().getPreference(ManagementSystem.PATH_TO_XML));
	    	    if (file.exists()) {
	    	    	//Log.log(getClass(), file.getAbsolutePath());
	    	        ArrayList<Product> products = new ProductHandler().parseFile(file);
	    	        Iterator<Product> iter = products.iterator();
	    	        
	    	        while (iter.hasNext()) {
	    	        	ManagementSystem.getInstance().insertProduct(iter.next());
	    	        }
    	        } else {
    	        	//TODO make feedback about bad pathfile or just ignore it...
    	        }
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
        }
    }
    
    @Override
    public void contextInitialized(ServletContextEvent event) {
        scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(new SomeDailyJob(), 0, 24, TimeUnit.HOURS);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        scheduler.shutdownNow();
    }
}


