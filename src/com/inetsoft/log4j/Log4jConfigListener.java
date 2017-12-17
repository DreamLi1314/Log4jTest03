package com.inetsoft.log4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Log4jConfigListener implements ServletContextListener {

	private static final String LOG4JDIRKEY = "log4jdir";

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		System.getProperties().remove(LOG4JDIRKEY);
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		String log4jdir = servletContextEvent.getServletContext().getRealPath("/") + "WEB-INF/";
		System.out.println("============log4jdir=============" + log4jdir);
		System.setProperty(LOG4JDIRKEY, log4jdir);
	}
}
