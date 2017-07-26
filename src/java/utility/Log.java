package utility;

import java.util.logging.Level;

import com.sun.istack.internal.logging.Logger;

public class Log {
	
	public static void log(Class<?> c, String s) {
		Logger.getLogger(c).log(Level.SEVERE, s);
	}
}
