package lesson23;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;

@WebServlet(urlPatterns = {"/book", "/load-book"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024*1024*10)

public class Servlet extends HttpServlet {
        private String path;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        path = req.getServletPath();

        if(path.equals("/load-book")) {
            try {
                Part filePart = req.getPart("file");
                String name = filePart.getSubmittedFileName();
                filePart.write("D:\\" + name);
                resp.getWriter().print("ok");
            } catch (Exception e) {
                resp.getWriter().print("smth wrong");
            }
        } else if(path.equals("/book")){

        }


    }
}
