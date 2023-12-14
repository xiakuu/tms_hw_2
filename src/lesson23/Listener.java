package lesson23;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class Listener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("start");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("stop");
    }
}
