package config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TestListener implements ServletContextListener {
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("톰캣이 종료될 때 ServletContextListener의 contextDestroyed()가 호출");
	}

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("톰캣이 처음 시작될 때 ServletContextListener의 contextInitialized()가 호출");
	}

}
