package homework.lesson23;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

import java.time.LocalDateTime;


@WebListener
public class ServletReqListener implements jakarta.servlet.ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println(LocalDateTime.now());
    }
}