package utility;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

import javafx.util.Pair;

public class ViewCounter {

	private static ViewCounter instance;
	private static ConcurrentHashMap<String, ArrayList<Pair<Long, Long>>> productViewCount;
	
	public static synchronized ViewCounter getInstance() {
		if (instance == null) {
			try {
				instance = new ViewCounter();
				productViewCount = new ConcurrentHashMap<>(); //TODO load from DB 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	//TODO should work asynchronically  
	public void increaseCount(String pId) {
    	if (productViewCount != null) {
    		ArrayList<Pair<Long, Long>> timeAndCount;
	    	if (productViewCount.containsKey(pId)) {
	    		timeAndCount = productViewCount.get(pId);
	    		int size = timeAndCount.size();
	    		long count = 1L;
	    		if (size > 0)
	    			count = timeAndCount.get(size-1).getValue();
	    		timeAndCount.add(new Pair<>(new Date().getTime(), ++count));
	    	} else {
	    		timeAndCount = new ArrayList<Pair<Long, Long>>();
	    		timeAndCount.add(new Pair<>(new Date().getTime(), 1L));
	    		productViewCount.put(pId, timeAndCount);
	    	}
    	}
	}
    
    public ConcurrentHashMap<?, ?> getViewCountOfAllProducts(){
    	return productViewCount;
    }
    
    public long getViewCountOfProduct(String pId) {
    	long count = 0L;
    	if (productViewCount.containsKey(pId)) {
    		ArrayList<Pair<Long, Long>> timeAndCount = productViewCount.get(pId);
    		int size = timeAndCount.size();
    		if (size > 0)
    			count = timeAndCount.get(size-1).getValue();
    	}
    	return count;
    }
}
