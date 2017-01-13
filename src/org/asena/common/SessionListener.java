
package org.asena.common;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener
{
	private static int totalActiveSessions;

	public static int getTotalActiveSession()
	{
		return totalActiveSessions;
	}


	@Override
	public void sessionCreated(HttpSessionEvent arg0)
	{
		totalActiveSessions++;
	}


	@Override
	public void sessionDestroyed(HttpSessionEvent arg0)
	{
		totalActiveSessions--;
	}

}
