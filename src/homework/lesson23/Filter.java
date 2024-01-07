package homework.lesson23;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
import java.util.Date;

@WebFilter(urlPatterns = {"/book","/load-book"})

public class Filter implements jakarta.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        jakarta.servlet.Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String ip = servletRequest.getRemoteAddr();
        String dateTime = new Date().toString();

        System.out.println("Request from: " + ip + " DATE: " + dateTime);

        filterChain.doFilter(servletRequest, servletResponse);


    }

    @Override
    public void destroy() {
        jakarta.servlet.Filter.super.destroy();
    }
}
