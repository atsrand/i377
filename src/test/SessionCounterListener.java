package test;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionCounterListener implements HttpSessionListener {
	
	private static int totalActiveSessions = 0;

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		totalActiveSessions++;
	}

	//It may go t -1 if you don't add if statement.
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		if (totalActiveSessions > 0){
			totalActiveSessions--;	
		}
	}
	
	public static int getActiveSessions() {
		return totalActiveSessions;
	}	
	
}
