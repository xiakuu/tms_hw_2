package homework.lesson23;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/book", "/load-book"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024*1024*10)

public class Servlet extends HttpServlet {
        private String path;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        path = req.getServletPath();

        if(path.equals("/load-book")) {
            try {
                Part filePart = req.getPart("file");
                String name = filePart.getSubmittedFileName();
                filePart.write("D:\\" + name);
                resp.getWriter().print("ok");
            } catch (Exception e) {
                resp.getWriter().print("smth wrong: " + e);
            }


        } else if(path.equals("/book")){
            PrintWriter out = resp.getWriter();

            String pdfName = "test.txt";

            String pdfPath = "C:\\";
            resp.setContentType("application/msword");
            resp.setHeader("Content-Disposition",
                    "attachment; filename=\""  + pdfName + "\"");

            FileInputStream inputStream = new FileInputStream(pdfPath + pdfName);


            int in;
            while ((in = inputStream.read()) != -1) {
                out.write(in);
            }

            inputStream.close();
            out.close();

        }


    }
}
